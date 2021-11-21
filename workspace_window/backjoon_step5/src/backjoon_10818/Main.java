package backjoon_10818;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10818
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++ ) {
			int data = sc.nextInt();
			if(min > data)
				min = data;
			if(max < data)
				max = data;
		}
		System.out.println(min + " " + max);
	}
}
