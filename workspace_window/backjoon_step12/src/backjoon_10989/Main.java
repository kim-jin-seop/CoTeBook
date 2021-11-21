package backjoon_10989;

import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =  Integer.parseInt(br.readLine());
		int[] data = new int[10001];
		for(int i = 0; i < N; i ++) {
			data[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1; i < 10001; i ++) {
			for(int j = 0; j < data[i]; j++) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
	}
}
