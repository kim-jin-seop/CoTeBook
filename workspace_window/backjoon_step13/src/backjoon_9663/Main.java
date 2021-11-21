package backjoon_9663;

import java.util.Scanner;

public class Main {
	static Location[] queen;
	static int N;
	static int Count;
	
	public static void main(String[] args) {
		N = new Scanner(System.in).nextInt();
		Count = 0;
		queen = new Location[N];
		
		for(int i = 1; i <= N; i++) {
			queen[0] = new Location(i,1);
			findLocation(2);
		}
		if(N == 1)
			System.out.println(1);
		else
			System.out.println(Count);
	}
	
	private static void findLocation(int level) {
		for(int i = 1; i <= queen.length; i ++) {
			int j;
			for(j = 1; j < level; j++) {
				if((queen[j-1].X + level-j == i) || (queen[j-1].X - level + j == i) || (queen[j-1].X == i))
					break;
			}
			if(j == level) {
				if(N == level) {
					Count++;
				}
				else {
					queen[level-1] = new Location(i,level);
					findLocation(level+1);
				}
			}
		}
	}
	
	public static class Location{
		int X;
		int Y;
		
		public Location(int x, int y) {
			X = x;
			Y = y;
		}
	}
}
