package backjoon_2908;
// https://www.acmicpc.net/problem/2908

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2 = sc.next();
		String result1 = "";
		String result2 = "";
		for(int i = 0; i < input1.length(); i++)
			result1 =  input1.charAt(i) + result1;
		for(int i = 0; i < input2.length(); i++)
			result2 = input2.charAt(i) + result2;
		if(Integer.parseInt(result1) > Integer.parseInt(result2))
			System.out.println(result1);
		else
			System.out.println(result2);
	}
}
