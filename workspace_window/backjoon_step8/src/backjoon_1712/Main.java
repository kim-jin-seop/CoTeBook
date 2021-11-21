package backjoon_1712;

import java.util.Scanner;

/*손익분기점
 * 입력
 * A : 고정비용
 * B : 가변비용
 * C : 가격
 * 출력 : 손익분기점 부분 출력*/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println((C-B)<= 0 ? -1 : (A/(C-B)+1) );
	}
}
