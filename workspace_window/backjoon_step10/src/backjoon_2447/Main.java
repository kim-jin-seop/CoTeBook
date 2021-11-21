package backjoon_2447;

import java.util.Scanner;

public class Main {
	static boolean[][] draw;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		draw = new boolean[N][N];
		Draw(0,0,N);
		
		for(int i = 0; i < N; i ++) {
			String print = "";
			for(int j = 0; j < N; j++) {
				if(draw[i][j])
					print += "*";
				else
					print += " ";
			}
			System.out.println(print);
		}
		//3 * 3 으로 생각
	}
	
	private static void Draw(int x, int y, int N) {
		if(N != 3) {
			for(int i = 0; i < 3; i ++) {
				for(int j = 0; j < 3; j ++) {
					if(i == 1 && j == 1)
						continue;
					Draw(x+(i*N/3),y+(j*N/3),N/3);
				}
			}
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(i == 1 && j == 1)
						continue;
					draw[i+x][j+y] = true; 
				}
			}
		}
	}
}
