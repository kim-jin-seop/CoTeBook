package backjoon_15651;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		check(N,M,"");
	}
	
	public static void check(int N, int M, String result) {
		if(M == 0)
			System.out.println(result);
		else {
			for(int i = 1; i <= N; i ++) {
				check(N,M-1,result + i + " ");
			}
		}
	}
}
