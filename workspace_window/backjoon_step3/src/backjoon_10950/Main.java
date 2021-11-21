package backjoon_10950;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10950

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		for(int i = 0; i < input; i ++) {
			System.out.println(sc.nextInt()+ sc.nextInt());
		}
	}
}
