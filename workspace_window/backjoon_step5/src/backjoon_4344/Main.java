package backjoon_4344;

import java.util.Scanner;

//https://www.acmicpc.net/problem/4344
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		for(int i = 0; i < C; i ++) {
			int N = sc.nextInt();
			double avg = 0;
			double[] arr = new double[N];
			for(int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				avg += arr[j];
			}
			avg = avg*1.0/N;
			
			int count = 0;
			for(int j = 0; j < N; j ++) {
				if(arr[j] > avg)
					count++;
			}

			String result = String.valueOf(Math.round(count*1.0/N*100*1000)/1000.);
			if(result.charAt(result.length()-2) == '.') {
				result = result + "00";
			}
			else if(result.charAt(result.length()-3) == '.') {
				result = result + '0';
			}
			result += "%";
			System.out.println(result);
		}
	}
}

