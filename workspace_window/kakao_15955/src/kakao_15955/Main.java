package kakao_15955;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 문제 링크 : https://www.acmicpc.net/problem/15955
 * 문제 이해
 * 입력 : N(체크포인트), Q(질의의 수), 체크포인트 좌표(X,Y), 질의(A,B,X : A번 체크포인트에서 B번 체크포인트로 최대 HP제한 X상태에서 움직일 수 있는가)
 * 출력 : 가능한지 불가능한지 YES or NO
 * 체크포인트에 도달하면 충전을 하거나 HP를 X만큼 회복하는 둘중에 한가지 방법을 사용할 수 있음
 * HP를 소모하면 그 거리만큼 갈 수 있음
 * 부스터는 x축 혹은 y축으로 한방향으로만 이동가능
 * 각각의 체크포인트에서 최대 한번만 재 충전 가능
 * */

public class Main {
	static int[] parent; // disjoint-set을 활용하기 위하여 생성한 부모배열
	
	public static void main(String[] args) {
		/* 입력   */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N -> 체크포인트 개수
		int Q = sc.nextInt(); // Q -> 질의의 개수
		
		Point[] point = new Point[N];  //point 배열 -> 체크포인트 정보 
		for(int i = 0 ; i < N ; i ++) {
			point[i] = new Point(sc.nextInt(),sc.nextInt(),i+1);
		}
	
		Question[] question = new Question[Q]; // question 배열 -> 질의의 정보
		for(int i = 0; i < Q; i++) {
			question[i] = new Question(sc.nextInt(),sc.nextInt(),sc.nextInt(),i);
		}
		
		Arrays.sort(question, new Comparator<Question>() { // question배열의 값들을 오름차순으로 정렬
			@Override
			public int compare(Question d1, Question d2) {
				return d1.life - d2.life; //오름차순 정렬
			}
		});
		String[] solution = new String[Q]; // 정렬을 하면, Question의 순서가 바뀌므로 그것을 처리해주기 위해 solution(string)을 따로 저장할 배열 생성
		
		/* x와 y로 정렬 후 묶어서 쌍 데이터 생성 */
		Pair[] pair = new Pair[2*N-2]; //정렬 후 쌍으로 데이터를 받기 위해 받은 Pair 배열
		Arrays.sort(point, new Comparator<Point>() { //point를 x에 대하여 정렬
			@Override
			public int compare(Point p1, Point p2) {
				return p1.x - p2.x; //오름차순 정렬
			}
		});
		for(int i = 0; i < N-1; i ++) { // 쌍을 저장 x를 기준으로 N-1개
			pair[2*i] = new Pair(point[i].num,point[i+1].num,(point[i+1].x-point[i].x));
		}
		Arrays.sort(point, new Comparator<Point>() { // point를 y에 대하여 정렬
			@Override
			public int compare(Point p1, Point p2) {
				return p1.y - p2.y; //오름차순 정렬
			}
		});
		for(int i =0; i < N-1; i ++) { // 쌍을 저장 y를 기준으로 N-1개
			pair[2*i+1] = new Pair(point[i].num,point[i+1].num,(point[i+1].y-point[i].y));
		}
		Arrays.sort(pair, new Comparator<Pair>() { // 쌍 배열을 distance를 고려하여 오름차순 정렬
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.distance - p2.distance; //오름차순 정렬
			}
		});
		
		/* 초기화 작업  */
		parent = new int[N+1]; // 부모 배열 초기화 작업
		for(int i = 1; i < N+1; i ++) // 초기 부모는 모두 자기 자신
			parent[i] = i;
		
		/* 알고리즘 해결 과정 */
		int maxLife = -1;  // maxLife -> Life가 바뀔 때마다 Union & find 수행
		int j = 0;         // 밖에서 선언함으로써, 필요없는 쌍의 데이터를 확인하는 것을 방지
		for(int i = 0; i < Q; i ++) { // 모든 질의에 대한 처리
			if(maxLife < question[i].life) { //만약, life가 바뀐 경우라면
				maxLife = question[i].life;
				for(; j < pair.length && pair[j].distance <= maxLife; j++) { // 저장되어있는 distance를 활용해 집합을 추가해줌
					Union(pair[j].num1,pair[j].num2);
				}
			}
			int start = find(question[i].start); // 시작점의 집합
			int finish = find(question[i].finish); // 끝 점의 집합
			if(start == finish) 
				solution[question[i].num] = "YES"; // question[i].num의 위치에 넣어줌으로써, 정렬로 인해 바뀐 순서 해결
			else
				solution[question[i].num] = "NO";
		}
		
		for(int i = 0; i < Q; i++)
			System.out.println(solution[i]); //결과 출력
	}

	/* Union */
	public static void Union(int p,int q) {
		int set1 = find(p);
		int set2 = find(q);
		parent[set1] = set2;
	}
	
	/* Find */
	public static int find(int p) {
		if(parent[p] == p)
			return p;
		else
			return parent[p] = find(parent[p]); //find를 수행할 때, tree의 level을 낮춰주는 역할을 수행
	}
	
	/* Question을 위한 class */
	public static class Question{
		int start; //시작점
		int finish;//끝점
		int life;  //받은 life
		int num;   //문제의 순서 0부터 시작
		
		public Question(int start, int finish, int life, int num) {
			this.start = start;
			this.finish = finish;
			this.life = life;
			this.num = num;
		}
	}
	
	/* Check Point를 위한 class */
	public static class Point{
		int x;   //x좌표
		int y;   //y좌표
		int num; //체크포인트의 번호
		
		public Point(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	/* 정렬된 check point를 쌍으로 묶은 데이터*/
	public static class Pair{
		int num1; //check point 1번의 번호
		int num2; //check point 2번의 번호
		int distance; // 둘 사이의 거리
		
		public Pair(int n1, int n2, int dis) {
			num1 = n1;
			num2 = n2;
			distance = dis;
		}
	}
	
}
