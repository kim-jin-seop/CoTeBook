package backjoon_2588;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a  = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a*(b-((b/10)-((b/100)*10))*10-((b/100)*100)));
		System.out.println(a*((b/10)-((b/100)*10)));
		System.out.println(a*(b/100));
		System.out.println(a*b);
	}
}