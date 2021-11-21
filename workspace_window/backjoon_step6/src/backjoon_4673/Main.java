package backjoon_4673;

// https://www.acmicpc.net/problem/4673
/*
 * 문제 이해
 * function d(n)은 각 자리수를 더하는 함수 : d(75) = 75 + 7 + 5 = 87
 * 셀프넘버는 d function을 통과해 생성할 수 없는 값이다.
 * 10000이하에서 셀프넘버 구하기
 * */
public class Main {
	private static boolean[] N_self_num = new boolean[10001];
	
	public static void main(String[] args) {
		for(int i = 1; i <= 10000; i++) {
			if(!selfNum(i))
				System.out.println(i);
		}
	}
	
	public static boolean selfNum(int n) {
		for(int i = 1; i <= n; i++) {
			if(N_self_num[n])
				return true;
			int d = d(i);
			if(d <=10000)
				N_self_num[d] = true;
		}
		return false;
	}
	
	public static int d(int n) {
		int result = n;
		while(n != 0) {
			result += (n%10);
			n = n/10;
		}
		return result;
	}
}
