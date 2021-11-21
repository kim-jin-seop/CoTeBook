package backjoon_2884;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt() + 24;
		int Min = sc.nextInt();
		int M =  Min + 60;
		
		M = (M-45)% 60;
		
		if(M > Min){
			H = (H-1);
		}
		
		H = H % 24;
		
		System.out.println(H+" "+M);
	}
}