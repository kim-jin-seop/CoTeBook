package backjoon_2739;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2739
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for(int i = 1; i < 10; i ++) {
			System.out.println(input+" * "+i+" = "+(input*i));
		}
	}
}
