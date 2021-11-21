package backjoon_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int data[] = new int[8001];
		
		for(int i = 0; i < N; i ++) {
			data[Integer.parseInt(br.readLine())+4000]++;
		}
		
		//산술평균
		int sum = 0;
		for(int i =0; i < 8001; i++) {
			sum += (i - 4000)*data[i];
		}
		System.out.println(Math.round(sum*1.0/N));
			
		//중앙값
		int center = N/2;
		for(int i = 0; i < 8001; i++) {
			center -= data[i];
			if(center < 0) {
				System.out.println(i-4000);
				break;
			}
		}
		
		//최빈값
		boolean isSecond = false;
		int mode = 0;
		for(int i = 0; i < 8001; i++) {
			if(data[mode] < data[i]) {
				mode = i;
				isSecond = false;
			}
			else if(!isSecond && data[mode] == data[i]) {
				isSecond = true;
				mode = i;
			}
		}
		System.out.println(mode-4000);
		
		//범위
		int min = -4000;
		int max = 4000;
		for(int i = 0; i < 8001; i++) {
			if(data[i] != 0)
				min = i - 4000;
		}
		for(int i = 8000; i >= 0; i--) {
			if(data[i] != 0)
				max = i - 4000;
		}
		System.out.println(min - max);
	}
}
