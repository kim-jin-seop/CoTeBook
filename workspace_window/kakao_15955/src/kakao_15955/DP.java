package kakao_15955;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class DP{
	/*Greedy and DP Solution
	 *메모리초과와 시간초과로 실패*/
	
	private static boolean find = false;
	private static boolean[][] ConnectionTable;
	private static int[][] point;

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //체크포인트 수
		int Q = sc.nextInt(); //질의의 수

		point = new int[N][2]; //체크포인트
		for(int i = 0; i < N; i ++) {
			point[i][0] = sc.nextInt();
			point[i][1] = sc.nextInt();
		}
		ConnectionTable = new boolean[N+1][N+1];


		int[][] question = new int[Q][3];	
		for(int i = 0; i < Q; i ++) {
			question[i][0] = sc.nextInt();
			question[i][1] = sc.nextInt();
			question[i][2] = sc.nextInt();
		}

		Arrays.sort(question, new Comparator<int[]>() {
			@Override
			public int compare(int[] d1, int[] d2) {
				return d1[2] - d2[2]; //오름차순 정렬
			}
		});

		//output
		int maxLife = -1;
		for(int i = 0; i < Q; i++) {
			boolean[] visit = new boolean[N];
			find = false;
			if(ConnectionTable[question[i][0]][question[i][1]]) {
				System.out.println("YES");
				continue;
			}
			else if((maxLife < question[i][2])||(!ConnectionTable[question[i][0]][question[i][0]] && !ConnectionTable[question[i][1]][question[i][1]])) {
				maxLife = question[i][2];
				recursiveMove(visit,question[i][0],question[i][1],question[i][2]);
			}

			if(!find)
				System.out.println("NO");
		}
	}

	public static void recursiveMove(boolean[] visit, int start, int finish, int life) {
		visit[start-1] = true;
		ConnectionTable[start][start] = true;
		if(start == finish) { //갈 수 있다면
			System.out.println("YES");
			find = true;
		}

		if(life != 0) { // life가 0이 아닌경우
			for(int i = 0; i < point[0].length; i++) {
				if(visit[i]) //만약 자기 자신의 좌표인 경우나 방문을 한 경우라면
					continue;
				Double distance = findDistance(point[0][start-1],point[1][start-1],point[0][i],point[1][i]); //최단거리를
				if(distance <= life) {
					ConnectionTable[start][i+1] = true;
					ConnectionTable[i+1][start] = true;
					recursiveMove(visit,i+1,finish,life);
				}
			}
		}
		else {
			for(int i = 0; i < point[0].length; i++) {
				if(visit[i]) //만약 자기 자신의 좌표인 경우나 방문을 한 경우라면
					continue;
				if((point[0][start-1] == point[0][i]) || (point[1][start-1] == point[1][i])) {
					ConnectionTable[start][i+1] = true;
					ConnectionTable[i+1][start] = true;
					recursiveMove(visit,i+1,finish,life);
				}
			}
		}
	}

	private static double findDistance(double ax, double ay, double bx, double by) {
		return Math.abs(ax-bx) > Math.abs(ay-by) ? Math.abs(ax-bx) : Math.abs(ay-by);
	}
}
