package backjoon_2580;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[][] Sudoku = new int[9][9];
	static ArrayList<int[]> iszero = new ArrayList<>();
	static boolean Sol = false;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j ++) {
				Sudoku[i][j] = sc.nextInt();
				if(Sudoku[i][j] == 0) {
					int[] array = {i,j};
					iszero.add(array);
				}
			}
		}
		
		SolveSudoku(iszero.get(0),1);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j ++) {
				System.out.print(Sudoku[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static void SolveSudoku(int[] location, int next) {
		for(int i = 1; i <= 9; i++) {
			Sudoku[location[0]][location[1]] = i;
			boolean isOk = true;
			
			int xlevel = location[0]/3;
			int ylevel = location[1]/3;
			for(int j = 0; j < 9 && isOk; j++) {
				if(3*xlevel+(j/3) == location[0] && 3*ylevel + (j%3) == location[1])
					continue;
				if(Sudoku[(3*xlevel) + (j/3)][(3*ylevel) + (j%3)] == i) {
					isOk = false;
				}
			}
			
			for(int j = 0; j < 9 && isOk; j ++) {
				if(location[1] == j )
					continue;
				if(Sudoku[location[0]][j] == i) {
					isOk = false;
				}
			}
			
			for(int j = 0; j < 9 && isOk; j ++) {
				if(location[0] == j)
					continue;
				if(Sudoku[j][location[1]] == i) {
					isOk = false;
				}
			}
			
			if(isOk) {
				if(next == iszero.size()) {
					Sol = true;
					return;
				}
				
				SolveSudoku(iszero.get(next), next+1);
				if(Sol)
					break;
				int[] nextlocation = iszero.get(next);
				Sudoku[nextlocation[0]][nextlocation[1]] = 0;
			}	
		}
	}
}
