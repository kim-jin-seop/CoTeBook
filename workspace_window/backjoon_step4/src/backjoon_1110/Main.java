package backjoon_1110;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1110
/*문제이해
 * 더하기 사이클
 * 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어지면, 연산 수행
 * 10보다 작다면 0을 붙여 두자리로 만듦
 * 두 수를 더하고, 원래 수의 뒤에 이어붙임
 * 얼만큼 돌아야 같은 수 나오는 지 사이클 수 출력
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int data = input;
		
		int cycle = 0;
		while(true) {
			data = (data%10)*10+((data/10) + (data%10))%10;
			cycle ++;
			if(input == data)
				break;
		}
		System.out.println(cycle);
	}
}
