package backjoon_2581;
/*소수
 * 입력 : M, N
 * 출력 : M과 N사이의 소수들의 합과 최소값 소수가 없으면 -1
 * */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int Min = 0;
		int Sum = 0;
		boolean minflag = true;
		for(int i = M; i <= N; i++ ) {
			int j;
			for(j = 2; j < i; j ++)
				if(i%j == 0)
					break;
			if(i == j) {
				Sum += i;
				if(minflag) {
					Min = i;
					minflag = false;
				}
			}
		}
		
		if(!minflag) {
			System.out.println(Sum);
			System.out.println(Min);
		}
		else {
			System.out.println(-1);
		}
	}
}
