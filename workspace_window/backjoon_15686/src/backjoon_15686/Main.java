package backjoon_15686;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//치킨 배달 문제 
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); //도시 크기 size*size
		int chickenNum = sc.nextInt(); //치킨집 개수
		ArrayList<Home> chickenStore = new ArrayList<Home>(); // 치킨집 정보
		ArrayList<Home> home = new ArrayList<Home>(); // 집 정보
		
		for(int i = 0; i < size; i++) { //집 정보와 치킨집 정보 입력
			for(int j = 0; j < size; j++) {
				int citydata = sc.nextInt();
				if(citydata == 1) {
					home.add(new Home(i,j));
				}
				else if(citydata == 2) {
					chickenStore.add(new Home(i,j));
				}
			}
		}
		FindShortDistance(chickenStore,home,chickenNum); //도시의 치킨거리의 최소값 출력
	}
	
	public static void FindShortDistance(ArrayList<Home> chickenStore, ArrayList<Home> home, int chickenNum) {
		boolean[] visited = new boolean[chickenStore.size()]; 
		Stack<ArrayList<Home>> CombinationDataList = new Stack<ArrayList<Home>>(); // 모든 치킨집에 대한 Combination한 데이터 Stack에 넣어줌
		Combination(chickenStore, visited, 0, chickenStore.size(), chickenNum,CombinationDataList);  // Combination 결과
		int CityDistance_Chicken = Integer.MAX_VALUE; // 도시의 최소 치킨거리
		while(!CombinationDataList.isEmpty()) { 
			ArrayList<Home> ChickenData = CombinationDataList.pop();
			int distance = 0; // 각각의 조합에 따른 치킨거리
			for(int i = 0; i < home.size(); i++) {
				int min = ChickenData.get(0).distance(home.get(i));
				for(int j = 1; j < ChickenData.size(); j++) { // 그 조합에서 최소 거리 계산
					if(min > ChickenData.get(j).distance(home.get(i))) {
						min = ChickenData.get(j).distance(home.get(i));
					}
				}
				distance += min;
			}
			if(distance < CityDistance_Chicken) {
				CityDistance_Chicken = distance;
			}
		}
		System.out.println(CityDistance_Chicken); 
	}
	
	/********************************Combination BackTracking**********************************************************************/
	//Combination - BackTracking 활용
	public static void Combination(ArrayList<Home> chickenStore, boolean[] visited, int index,int n, int r, Stack<ArrayList<Home>> st) {
		if(r == 0) {
			st.add(Combination_element(chickenStore, visited, n));
        } else {
            for(int i = index; i < n; i++) {
                visited[i] = true;
                Combination(chickenStore, visited, i + 1, n, r - 1,st);
                visited[i] = false;
            }
        }
	}
	
	//Combination을 한 결과 원소를 ArrayList에 담아서 Return
	public static ArrayList<Home> Combination_element(ArrayList<Home> chickenStore, boolean[] visited, int n) {
		ArrayList<Home> Com = new ArrayList<Home>();
        for(int i = 0; i < n; i++) {
            if(visited[i] == true)
            	Com.add(chickenStore.get(i));
        }
        return Com;
    }
	/********************************Combination BackTracking**********************************************************************/
	
	public static class Home{
		private int x; //x좌표
		private int y; //y좌표
		
		public Home(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int distance(Home h) { // 집 거리
			return Math.abs(h.x - x) + Math.abs(h.y - y);
		}
	}
}
