package backjoon_8958;

import java.util.Scanner;

// https://www.acmicpc.net/problem/8958
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i ++) {
			String input = sc.next();
			int score = 0;
			int point = 0;
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == 'O') {
					point++;
					score += point;
				}
				else {
					point = 0;
				}
			}
			arr[i] = score;
		}
		
		for(int i = 0; i < N; i ++) {
			System.out.println(arr[i]);
		}
	}
}
