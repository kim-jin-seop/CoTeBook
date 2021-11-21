package backjoon_10817;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		System.out.println(A > B? A > C ? B > C ? B : C : A: B > C ? C > A ? C : A : B);
	}
}

