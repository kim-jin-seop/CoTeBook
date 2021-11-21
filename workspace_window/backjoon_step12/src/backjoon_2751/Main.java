package backjoon_2751;

import java.io.*;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> data = new PriorityQueue<Integer>();
		
		for(int i = 0; i < N; i ++) {
			data.add(Integer.parseInt(br.readLine()));
		}

		for(int i = 0; i < N; i ++) {
			bw.write(data.remove()+"\n");
		}
		bw.flush();

	}
}
