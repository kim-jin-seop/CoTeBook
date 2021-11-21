package backjoon_1152;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] result = new Scanner(System.in).nextLine().split(" ");
		int count = 0;
		for(int i = 0; i < result.length; i ++) {
			if(!result[i].equals(""))
				count++;
		}
		System.out.println(count);
	}
}
