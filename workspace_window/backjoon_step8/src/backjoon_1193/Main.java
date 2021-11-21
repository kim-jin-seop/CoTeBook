package backjoon_1193;

import java.util.Scanner;

/*분수찾기
 * n번째 위치의 분수를 출력
 * 입력 : X (X번째 위치의 값)
 * 출력 : 그 위치의 분수값
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int i = 1;
		
		while(true) {
			if(X <= i)
				break;
			X = X-i;
			i++;
		}
		int left;
		int right;
		
		if((i%2) == 0) {
			left = 1;
			right = i;
			left += X-1;
			right -= X-1;
		}
		else {
			left = i;
			right = 1;
			left -= X-1;
			right += X-1;
		}
		System.out.println(left + "/" + right);
	}
}
