package kakao_15955;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*다익스트라*/
public class Dijkstra{
	public static void main(String[] args) {
		Map<Integer,double[]> distanceMap = new HashMap<Integer,double[]>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //체크포인트 수
		int Q = sc.nextInt(); //질의의 수

		int[][] point = new int[N][2]; //체크포인트
		for(int i = 0; i < N; i ++) {
			point[i][0] = sc.nextInt();
			point[i][1] = sc.nextInt();
		}

		int[][] quest = new int[Q+1][3];
		for(int i = 0; i < Q; i++) {
			quest[i][0] = sc.nextInt();
			quest[i][1] = sc.nextInt();
			quest[i][2] = sc.nextInt();
		}

		for(int i = 0; i < Q; i ++) {
			if(distanceMap.containsKey(quest[i][0])) {
				double[] distance = distanceMap.get(quest[i][0]);
				if(distance[quest[i][1]] <= quest[i][2])
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			else if(distanceMap.containsKey(quest[i][1])) {
				double[] distance = distanceMap.get(quest[i][1]);
				if(distance[quest[i][0]] <= quest[i][2])
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			else {
				double[] distance = new double[N+1];
				boolean[] check = new boolean[N+1];
				for(int j = 0; j < N+1; j ++) {
					distance[j] = Double.MAX_VALUE;
				}
				distance[quest[i][0]] = 0;
				check[quest[i][0]] = true;

				for(int j = 1; j < N+1; j ++) {
					distance[j] = findDistance(point[quest[i][0]-1][0],point[quest[i][0]-1][1],point[j-1][0],point[j-1][1]);
				}
				/////
				while(true) {
					int Min_index = 0;
					for(int j = 1; j < N+1; j++) {
						if(distance[Min_index] > distance[j] && !check[j]) {
							Min_index = j;
						}
					}
					if(Min_index == 0) {
						if(distance[quest[i][1]] <= quest[i][2])
							System.out.println("YES");
						else {
							System.out.println("NO");
						}
						distanceMap.put(quest[i][0], distance);
						break;
					}
					else {
						for(int j = 1; j < N+1; j ++) {
							double dis = findDistance(point[j-1][0],point[j-1][1],point[Min_index-1][0],point[Min_index-1][1]) + distance[Min_index];
							if(dis < distance[j]) {
								distance[j] = dis;
							}
						}
						check[Min_index] = true;
					}
				}
			}
		}
	}

	private static double findDistance(int ax, int ay, int bx, int by) {	
		return Math.abs(ax-bx) < Math.abs(ay-by) ? Math.abs(ax-bx) : Math.abs(ay-by);
	}
}
