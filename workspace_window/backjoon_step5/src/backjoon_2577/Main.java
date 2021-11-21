package backjoon_2577;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2577
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int Mul = A*B*C;
		int[] arr = new int[10];
		
		while(Mul != 0) {
			arr[Mul%10]++;
			Mul = Mul/10;
		}
		for(int i = 0; i < arr.length; i ++) {
			System.out.println(arr[i]);
		}
	}
}
