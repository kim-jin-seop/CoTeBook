package backjoon_1018;

import java.util.Scanner;

/*
 * 문제 링크 : https://www.acmicpc.net/problem/1018
 * 문제 해석
 * M*N의 크기의 보드에서 8*8 크기의 체스판 획득하기 위해 색을 칠해야하는 최소값 계산
 * N과 M은 8이상 50이하
 * W는 white, B는 black 이 둘이 번갈아가며 색칠이 되어야함.
 * 맨 왼쪽이 검은색인지 흰색인지 구분하여 구현
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // M 사각형의 세로
		int N = sc.nextInt(); // N 사각형의 가로
		char[][] input = new char[M][N]; //색칠된 사각형을 받기 위한 이차원 배열

		for(int i = 0; i < M; i ++) { // 사각형 받기
			String data = sc.next();
			for(int j = 0; j < N; j ++) {
				input[i][j] = data.charAt(j);
			}
		}

		/*맨 왼쪽 위가 흰색인 경우*/
		boolean isBlack,startPoint; // isBlack은 이전의 것이 검은색인지?, startPoint는 처음 시작하는 위치가 무슨색인지 확인
		int Min = Integer.MAX_VALUE; // 최소값
		for(int i = 0; i <= M-8;i++) { // 8칸만 확인
			for(int j = 0; j <= N-8; j++) { // 8칸만 확인
				int changeNum = 0;
				startPoint = true; // startPoint가 true -> 맨왼쪽 위의 박스가 흰색인 경우
				for(int y = 0; y < 8; y ++) {
					if(startPoint) //y좌표를 하나씩 내리면 startPoint의 true false가 변경되어야함(체스판 원리)
						startPoint = false;
					else
						startPoint = true;
					isBlack = startPoint; 
					for(int x = 0; x < 8; x++) { //x좌표로 이동하며 계산
						if(isBlack) {
							if(input[i+y][j+x] == 'B') { //이전의 것이 black인데 black인 경우(색을 칠해야함)
								changeNum++;
							}
							isBlack = false;
						}
						else { // 그 반대의 경우
							if(input[i+y][j+x] == 'W') {
								changeNum++;
							}
							isBlack = true;
						}
					}
				}
				if(changeNum < Min) {
					Min = changeNum;
				}
				
				/*맨 왼쪽 위가 검은색인 경우*/
				changeNum = 0;
				startPoint = false; // startPoint가 false -> 맨왼쪽 위의 박스가 검은색인 경우
				for(int y = 0; y < 8; y ++) {
					if(startPoint)
						startPoint = false;
					else
						startPoint = true;
					isBlack = startPoint;
					for(int x = 0; x < 8; x++) {
						if(isBlack) {
							if(input[i+y][j+x] == 'B') {
								changeNum++;
							}
							isBlack = false;
						}
						else {
							if(input[i+y][j+x] == 'W') {
								changeNum++;
							}
							isBlack = true;
						}
					}
				}
				if(changeNum < Min) {
					Min = changeNum;
				}

			}
		}
		System.out.println(Min);
	}
}
