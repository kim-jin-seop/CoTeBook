package backjoon_10870;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(Fibonacci(new Scanner(System.in).nextInt()));
	}
	
	private static int Fibonacci(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		else
			return Fibonacci(n-1) + Fibonacci(n-2);
	}
}
