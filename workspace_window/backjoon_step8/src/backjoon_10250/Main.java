package backjoon_10250;
/*ACM 호텔
 * 손님의 방을 배정하는 프로그램 개발
 * 가장 가까운 방을 선호 따라서 가장 가까운 방부터 채워 넣어줌
 * 입력 : H(높이), W(가로), N(n번째 손님)
 * 출력 : n번째 손님이 묵을 호텔 방 번호
 * 
 * */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //Test case
		String[] result = new String[T];
		
		for(int i = 0; i < T; i ++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int room = N/H + 1; //호수
			int floor = N%H; //층수
			
			if(floor == 0) { //floor가 0이 되는 경우 예외처리
				floor = H;
				room = room -1;
			}
			if(room < 10) {
				result[i] = floor + "0" + room;
			}
			else {
				result[i] = floor + "" + room;
			}
		}
		
		for(int i = 0; i < T; i++)
			System.out.println(result[i]);
	}
}
