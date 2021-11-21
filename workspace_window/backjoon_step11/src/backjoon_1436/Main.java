package backjoon_1436;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int i = 666;
		
		int count = 1;

		while(count != N) {
			i ++;
			if(String.valueOf(i).contains("666"))
				count ++;
		}
		System.out.println(i);
		
	}
}
