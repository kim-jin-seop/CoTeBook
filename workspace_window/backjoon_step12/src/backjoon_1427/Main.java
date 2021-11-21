package backjoon_1427;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		while(N != 0) {
			queue.add(N%10);
			N = N/10;
		}
		String result = "";
		while(!queue.isEmpty())
			result =  queue.remove()+ result;
		System.out.print(result);
	}
}
