package backjoon_15552;

import java.io.*;

//https://www.acmicpc.net/problem/15552
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String input = br.readLine();
			String[] array = input.split(" ");
			bw.write((Integer.parseInt(array[0])+ Integer.parseInt(array[1]))+"\n");
		}
		bw.flush();
	}

}
