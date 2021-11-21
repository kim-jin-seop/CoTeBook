package backjoon_2231;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		
		int i = 0;
		
		for(i = 1;i <= N; i++) {
			int gen = i;
			int result = i;
			while(gen != 0) {
				result += gen % 10;
				gen = gen / 10;
			}
			
			if(result == N) {
				break;
			}
		}
		
		if(i == N + 1) {
			System.out.println(0);
		}
		else {
			System.out.println(i);
		}
	}
}
