package backjoon_10871;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10871
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		for(int i = 0; i < N; i ++) {
			int data = sc.nextInt();
			if(data < X) {
				System.out.print(data+" ");
			}
		}
	}
}
