package backjoon_11720;// https://www.acmicpc.net/problem/11720

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		String data = sc.next();
		int result = 0;
		for(int i = 0; i < data.length(); i ++) {
			result += data.charAt(i) - 48;
		}
		System.out.println(result);
	}
}
