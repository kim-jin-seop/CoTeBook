package backjoon_10809;
// https://www.acmicpc.net/problem/10809

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[] result = new int[26];
		
		for(int i = 0; i < result.length; i ++)
			result[i] = -1;
		for(int i = 0; i < input.length(); i++) {
			if(result[input.charAt(i)-97] == -1)
				result[input.charAt(i)-97] = i;
		}
		
		for(int i =0; i< result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
} 
