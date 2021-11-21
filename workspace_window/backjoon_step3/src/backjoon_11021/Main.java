package backjoon_11021;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11021
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i++) {
			System.out.println("Case #"+i+": "+(sc.nextInt()+sc.nextInt()));
		}
	}
}
