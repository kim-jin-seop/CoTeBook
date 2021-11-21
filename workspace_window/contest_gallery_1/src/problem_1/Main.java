package problem_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;



/*순례의 시작
 * 순례는 (pi / wi)의 합이 커질수록 편해짐
 * 총 8개의 성물을 선택가능
 * 입력 : N, p, w
 * 출력 : N - 7줄에 걸쳐서 출력, 순례가 편해지는 정도의 최대값 출력
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); //받는 성물의 수
		
		ArrayList<HolyThing> ht = new ArrayList<HolyThing>(); // 손에 쥐고 있는 성물 8개
		
		int Sum_P = 0; // P의 합
		int Sum_W = 0; // W의 합
		double prev_value = 0; //이전에 성물의 무게
		
		for(int i = 0; i < N; i ++) { // 반복문으로 N개의 성물을 받는 경우
			ht.add(new HolyThing(sc.nextInt(),sc.nextInt()));
			if(i > 6) { // 성물 8개 부터 출력 시작
				boolean[] visited = new boolean[i+1]; 
				Stack<ArrayList<HolyThing>> CombinationDataList = new Stack<ArrayList<HolyThing>>();
				Combination(ht, visited, 0, i+1, 8,CombinationDataList);
				double Max = Double.MIN_VALUE;
				while(!CombinationDataList.isEmpty()) {
					ArrayList<HolyThing> data = CombinationDataList.pop();
					int sum_P = 0;
					int sum_W = 0;
					for(int j = 0; j < data.size(); j++) {
						sum_P += data.get(j).P;
						sum_W += data.get(j).W;
					}
					if(sum_P*1.0/sum_W > Max) {
						Max = sum_P*1.0/sum_W;
					}
				}
				System.out.println(Max);
			}
			
		}
	}
	
	public static void Combination(ArrayList<HolyThing> holyThing, boolean[] visited, int index,int n, int r, Stack<ArrayList<HolyThing>> st) {
		if(r == 0) {
			st.add(Combination_element(holyThing, visited, n));
        } else {
            for(int i = index; i < n; i++) {
                visited[i] = true;
                Combination(holyThing, visited, i + 1, n, r - 1,st);
                visited[i] = false;
            }
        }
	}
	
	//Combination을 한 결과 원소를 ArrayList에 담아서 Return
	public static ArrayList<HolyThing> Combination_element(ArrayList<HolyThing> holyThing, boolean[] visited, int n) {
		ArrayList<HolyThing> Com = new ArrayList<HolyThing>();
        for(int i = 0; i < n; i++) {
            if(visited[i] == true)
            	Com.add(holyThing.get(i));
        }
        return Com;
    }
	
	static class HolyThing{
		int P;
		int W;
		
		public HolyThing(int P, int W) {
			this.P = P;
			this.W = W;
		}
	}
}
