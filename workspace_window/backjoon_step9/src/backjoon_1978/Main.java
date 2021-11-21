package backjoon_1978;

import java.util.Scanner;

public class Main {
	/*소수 찾기
	 * 입력받은 수 중에 소수의 개수 출력
	 * 입력 : 숫자들
	 * 출력 : 소수의 개수
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int count = 0;
		for(int i = 0; i < T; i ++) {
			int number = sc.nextInt();
			int j = number-1;
			for(; j > 1; j--) {
				if(number%j == 0)
					break;
			}
			if(j == 1)
				count++;
		}
		System.out.println(count);
	}
}
