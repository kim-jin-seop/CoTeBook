package kakao_15955;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


// Disjoint-Set
public class Disjoint_set{
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt();
		int Q = sc.nextInt();
		
		int[][] point = new int[N][2];
		for(int i = 0; i < N ; i ++) {
			point[i][0] = sc.nextInt();
			point[i][1] = sc.nextInt();
		}
		
		int[][] quest = new int[Q][3];
		for(int i = 0; i < Q; i++) {
			quest[i][0] = sc.nextInt();
			quest[i][1] = sc.nextInt();
			quest[i][2] = sc.nextInt();
		}
		Arrays.sort(quest, new Comparator<int[]>() {
			@Override
			public int compare(int[] d1, int[] d2) {
				return d1[2] - d2[2]; //오름차순 정렬
			}
		});
		
		

		double distance;
		parent = new int[N+1];
		for(int i = 1; i < N+1; i ++)
			parent[i] = i;

		for(int i = 0; i < quest.length; i ++) {
			int j;
			for(j = 0; j < N; j ++) {
				if(find(quest[i][0]) == find(quest[i][1])) {
					break;
				}
				distance = findDistance(point[j][0],point[j][1], point[quest[i][0]-1][0],point[quest[i][0]-1][1]);
				if(distance <= quest[i][2] && (find(quest[i][0]) != find(j+1)))
					Union(j+1,quest[i][0]);
				if(find(quest[i][0]) == find(j+1)) {
					distance = findDistance(point[j][0],point[j][1], point[quest[i][1]-1][0],point[quest[i][1]-1][1]);
					if(distance <= quest[i][2])
						Union(j+1,quest[i][1]);
				}
			}
			if(find(quest[i][0]) == find(quest[i][1]))
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
	}
	
	public static void Union(int p,int q) {
		int set1 = find(p);
		int set2 = find(q);
		if(set1 == set2)
			return;
		parent[set2] = set1;
	}
	
	public static int find(int p) {
		if(parent[p] == p)
			return p;
		else
			return parent[p] = find(parent[p]);
	}
	
	private static double findDistance(int ax, int ay, int bx, int by) {	
		return Math.abs(ax-bx) < Math.abs(ay-by) ? Math.abs(ax-bx) : Math.abs(ay-by);
	}
}