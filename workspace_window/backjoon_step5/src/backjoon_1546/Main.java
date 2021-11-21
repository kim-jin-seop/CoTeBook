package backjoon_1546;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1546
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double Max = Integer.MIN_VALUE;
		int N = sc.nextInt();
		double[] arr = new double[N];
		
		for(int i = 0; i < N; i ++) {
			arr[i] = sc.nextInt();
			if(arr[i] > Max)
				Max = arr[i];
		}
		
		double Sum = 0;
		for(int i = 0; i < N; i++) {
			Sum += arr[i]/Max*100;
		}
		System.out.println(Sum/N);
	}
}
