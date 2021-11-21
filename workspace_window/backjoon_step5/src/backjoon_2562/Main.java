package backjoon_2562;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Max = sc.nextInt();
		int index = 1;
		for(int i = 1; i < 9; i ++) {
			int data = sc.nextInt();
			if(Max < data) {
				index = i + 1;
				Max = data;
			}
		}
		System.out.println(Max);
		System.out.println(index);
	}
}
