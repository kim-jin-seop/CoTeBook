package backjoon_1929;
/*소수 구하기
 * M 이상 N 이하의 소수 출력
 * M과 N은 1000000이하
 * 순서대로 M부터 N까지 소수 출력
 * 입력 : M, N
 * 출력 : M부터 N까지의 소수 출력
 * */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i = M; i <= N; i ++) {
			int j;
			boolean isPrime = true;
			for(j = 2; j*j <= i; j ++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(i != 1 && isPrime) {
				System.out.println(i);
			}
		}
	}
}