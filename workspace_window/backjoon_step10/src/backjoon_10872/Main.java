package backjoon_10872;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int result = 1;
		int N = (new Scanner(System.in)).nextInt();
		for(int i = 1; i <= N; i ++)
			result *= i;
		System.out.println(result);
	}
}
