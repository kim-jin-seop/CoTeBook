package backjoon_2292;

import java.util.Scanner;

/*벌집
 * 시작을 포함하여 끝점까지 가는데 몇개의 칸을 거쳐가야하는지 계산
 * 계차가 등차수열인 수열로 계산
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int Count = 1;
		while(true) {
			if(input <= 1) {
				System.out.println(Count);
				break;
			}
			input = input - (6*Count);
			Count++;
		}
	}
}
