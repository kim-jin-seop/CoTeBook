package backjoon_2775;

import java.util.Scanner;

/*부녀회장이 될테야
 * 아파트의 거주 조건 a층 b호에 살려면 (a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야함.
 * 아파트는 0층부터 있고, 각 층에는 1호부터있으며, 0층의 i호에는 i명이 거주함
 * k층에 n호에 몇명이 살고 있는지 출력
 * 
 * 입력 : T(Test Case), k, n
 * 출력 : 몇명이 살고 있는지 출력
 * */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i ++) {
			System.out.println(resident(sc.nextInt(),sc.nextInt()));
		}
	}
	
	public static int resident(int floot, int k) { //재귀 활용
		if(floot == 0) // 맨 아래층 인원 i
			return k;
		if(k == 1)     // 1호는 항상 1
			return 1;
		return resident(floot,k-1) + resident(floot-1,k); //현재 호수 값은 같은층 이전호수 + 아래 호수
	}
}
