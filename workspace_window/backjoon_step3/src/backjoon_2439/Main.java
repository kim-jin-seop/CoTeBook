package backjoon_2439;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2439
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i ++) {
			for(int j = i+1; j < input; j ++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j <=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
