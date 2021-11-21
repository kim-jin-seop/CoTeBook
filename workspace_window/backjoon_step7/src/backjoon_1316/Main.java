package backjoon_1316;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1316

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Count = 0;
		for(int i = 0; i < N; i ++) {
			boolean[] check = new boolean[26];
			String S = sc.next();
			char prev = S.charAt(0);
			for(int j=0; j < S.length(); j++) {
				if(prev != S.charAt(j) && check[S.charAt(j)-97]) {
					Count++;
					break;
				}
				prev = S.charAt(j);
				check[S.charAt(j)-97] = true;
			}
		}
		System.out.println(N-Count);
	}
}
