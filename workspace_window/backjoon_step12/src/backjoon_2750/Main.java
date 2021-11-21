package backjoon_2750;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] data = new int[N];
		for(int i = 0; i < N ; i ++) {
			data[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N-1; i ++) {
			for(int j = 0; j < N-1; j ++) {
				if(data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		
		for(int i = 0; i < N; i ++)
			System.out.println(data[i]);
	}
}
