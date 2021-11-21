package backjoon_1065;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1065
/*문제이해
 * 한수 찾기
 * 어떤 양의 정수 X의 자리수가 등차수열을 이루면 그 수를 한수라고함
 * 입력 : 양의 정수 X
 * 출력 : 양의정수 X이하의 자연수중 한수의 개수 출력
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int count = 0;
		for(int i = 1; i <= X; i ++) {
			if(isHan(i))
				count++;
		}
		System.out.println(count);
	}
	
	public static boolean isHan(int n) {
		int prev = n%10;
		n = n/10;
		int next = n%10;
		int diff = prev- next;
		
		while(n!=0) {
			prev = n%10;
			n = n/10;
			next = n%10;
			if(next == 0 && n == 0)
				break;
			if(diff != (prev-next))
				return false;
		}
		return true;
	}
}
