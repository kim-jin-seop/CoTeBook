package backjoon_5622;
// https://www.acmicpc.net/problem/5622

import java.util.Scanner;

/*문제이해
 * 다이얼의 타이머 계산하기
 * 문자열 입력을 통해 얻은 다이얼을 돌리는 데 걸리는 시간 계산
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int Time = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if('A' <= input.charAt(i) && 'C' >= input.charAt(i))
				Time = Time + 3;
			else if('D' <= input.charAt(i) && 'F' >= input.charAt(i))
				Time = Time + 4;
			else if('G' <= input.charAt(i) && 'I' >= input.charAt(i))
				Time = Time + 5;
			else if('J' <= input.charAt(i) && 'L' >= input.charAt(i))
				Time = Time + 6;
			else if('M' <= input.charAt(i) && 'O' >= input.charAt(i))
				Time = Time + 7;
			else if('P' <= input.charAt(i) && 'S' >= input.charAt(i))
				Time = Time + 8;
			else if('T' <= input.charAt(i) && 'V' >= input.charAt(i))
				Time = Time + 9;
			else if('W' <= input.charAt(i) && 'Z' >= input.charAt(i))
				Time = Time + 10;
			else
				Time = Time + 11;
		}
		System.out.println(Time);
	}
}
