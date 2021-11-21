package backjoon_2798;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] data = new int[N];
		
		for(int i = 0; i < N; i ++)
			data[i] = sc.nextInt();
		
		int find = Integer.MIN_VALUE;
		
		for(int i = 0; i < N-2; i ++) {
			for(int j = i + 1; j < N-1 ; j++) {
				for(int k = j + 1; k < N; k ++) {
					int result = data[i] + data[j] + data[k];
					if(result < M) { 
						if(find < result)
							find = result;
					}
					else if(result == M) {
						System.out.println(M);
						return;
					}
				}
			}
		}
		
		System.out.println(find);
	}
}
