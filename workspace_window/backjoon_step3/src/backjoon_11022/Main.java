package backjoon_11022;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11022
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for(int i= 1; i <= input; i ++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.printf("Case #%d: %d + %d = %d\n",i,A,B,A+B);
		}
	}
}
