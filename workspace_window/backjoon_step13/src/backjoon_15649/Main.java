package backjoon_15649;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		check(M,N,"");
	}
	
	private static void check(int M, int N, String result) {
		if(M == 0) {
			System.out.println(result);
		}
		else {
			for(int i = 1; i <= N; i ++) {
				if(!result.contains(String.valueOf(i))) {
					check(M-1,N, result + i+" ");
				}
			}
		}
	}
}
