package backjoon_9020;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> decimal = new ArrayList<Integer>();
		decimal.add(2);
		for(int i = 3; i < 10000; i ++) {
			boolean check = false;
			for(int j = 2; j*j <= i; j ++) {
				if(i % j == 0) {
					check = true;
					break;
				}
			}
			if(!check)
				decimal.add(i);
		}
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i ++) {
			int n = sc.nextInt();
			int findX1 = 0,findX2 = 0;
			
			for(int j = 0; j < decimal.size(); j ++) {
				int first = decimal.get(j);
				for(int k = j; k < decimal.size(); k++) {
					int second = decimal.get(k);
					if(first + second == n) {
						findX1 = first;;
						findX2 = second;
						break;
					}
					else if(first + second > n)
						break;
				}
				if(first+first > n)
					break;
			}
			System.out.println(findX1 + " " + findX2);
		}
	}
}
