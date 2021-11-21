package backjoon_1085;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		System.out.println(w - x > x ? h-y > y ? x > y ? y : x : x > h-y ? h-y : x : h-y > y ? y > w-x ? w-x : y : h-y > w-x ? w-x : h-y);
	}
}
