package backjoon_7568;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] data = new int[N][2];
		
		for(int i = 0; i< N; i ++) {
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i ++) {
			int count = 0;
			for(int j = 0; j < N; j ++) {
				if(data[i][0] < data[j][0] && data[i][1] < data[j][1])
					count ++;
			}
			System.out.print((count+1) + " ");
		}
	}
}
