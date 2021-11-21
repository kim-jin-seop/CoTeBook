package backjoon_2869;

import java.util.Scanner;
/*달팽이는 올라가고 싶다
 * V미터의 막대를 올라감
 * 매일 A미터씩 올라가고 B미터씩 미끄러짐
 * 몇일만에 정상에 올라갈까?
 * 입력 : A, B, V
 * 출력 : 며칠
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int day = V/(A-B);     // day는 V / (A-B)를 수행해주면, A > B이므로 항상 원하는 결과가 나옴
	
		while(true) {
			if((V-((day-1)*(A-B))-A) <= 0) { // 이전에 오를수도 있음에 대한 예외처리
				day--;
			}else {
				break;
			}
		}
		System.out.println(day+1);
	}
}
