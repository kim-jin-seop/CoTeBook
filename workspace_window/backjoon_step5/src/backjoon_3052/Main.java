package backjoon_3052;

import java.util.Scanner;

// https://www.acmicpc.net/problem/3052
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[42];
		
		for(int i = 0; i < 10; i++) {
			arr[sc.nextInt()%42] = true ;
		}
		
		int count = 0;
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i])
				count ++;
		}
		System.out.println(count);	
	}
}
