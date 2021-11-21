package backjoon_15650;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i = 1; i <= N-M+1; i ++) {
			select(N,M-1,i,"" + i);
		}
	}
	
	private static void select(int N, int M, int front, String result) {
		if(M == 0) {
			System.out.println(result);
		}else {
			for(int i = front+1; i <= N; i++) {
				select(N,M-1,i,result +  " " + i);
			}
		}
	}
}
