package backjoon_2438;

import java.util.Scanner;
// https://www.acmicpc.net/problem/2438
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i ++) {
			for(int j = 0; j <= i; j ++)
				System.out.print("*");
			System.out.println();
		}
	}
}
