package backjoon_2839;

import java.util.Scanner;

/*설탕 배달
 * 설탕을 Nkg배달 : 봉지는 3kg과 5kg 가지고 있음
 * 최대한 적은 봉지로 N을 맞추면 됨
 * 
 * 입력 : N
 * 출력 : 봉지의 수(만들 수 없으면 -1)
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = N/5; i >=0; i--) {
			int remainder = N - 5*i;
			if(remainder == 0) {
				System.out.println(i);
				return;
			}
			else {
				if(remainder > 0 && remainder%3 == 0) {
					System.out.println((i+(remainder/3)));
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
