package backjoon_1011;

import java.util.Scanner;

/*Fly me to the Alpha Centauri
 * 만약 k칸 갔다면, 다음 칸에서는 k-1, k, k+1칸 중 하나를 선택해 이동
 * 가장 적게 이동해서 목적지 도달하는 게 목표
 * 마지막 지점 도달 전에는 항상 1의 위치 해야함.
 * x지점에서 y지점으로 가는데 걸리는 공간
 * 
 * 입력 : x , y
 * 출력 : 총 필요한 공간이동 수
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i ++) {
			int distance = -sc.nextInt() + sc.nextInt();
			int n = (int)Math.ceil(Math.sqrt(distance)); 
			System.out.println(distance > n*(n-1) ? 2*n-1 : 2*n-2);
		}
	}
}
