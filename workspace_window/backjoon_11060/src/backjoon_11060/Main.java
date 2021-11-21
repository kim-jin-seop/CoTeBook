package backjoon_11060;
//점프 점프 
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] road = new int[size];
		int status = 0;
		int finish = size-1;
		
		//status -> finish의 최단 경로 구하기
		for(int i = 0; i < size; i++) {
			road[i] = sc.nextInt();
		}
		
		int jumpnum = 0;
		int maxlocation = -1; // 종료조건을 위하여 -1로 초기 설정
		while(true) {
			if(status == finish) { // 종료조건 1 최종 도달하였을 때 
				System.out.println(jumpnum);
				break;
			}
			if(maxlocation == status) { // 종료조건 2 더 이상 앞으로 나아갈 수 없을 때
				System.out.println(-1);
				break;
			}
			else if(maxlocation != -1) { // 다음 위치로 점프
				status = maxlocation;
				jumpnum++;
			}
		
			int jumpdata = road[status];
			if((status + jumpdata) >= finish) { // 종료조건에 해당(최종적으로 finish로 갈 수 있을 때
				status = finish;
				jumpnum++;
				continue;
			}
			maxlocation = status; //최대한 앞으로 나아갈 수 있는 위치
			int maxindex = 1;
			for(int i = 1; i <= jumpdata; i++) { //maxlocation 찾아주기
				if(i == 1) {
					maxlocation++;
					continue;
				}
				if(road[maxlocation]+maxindex < road[status+i]+i) {
					maxindex = i;
					maxlocation = status + i;
				}
			}
		}
	}
}


