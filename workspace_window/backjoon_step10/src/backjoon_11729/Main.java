package backjoon_11729;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<String> result = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Hanoi(new Scanner(System.in).nextInt(),1,3,2);
		System.out.println(result.size());
		for(int i = 0; i < result.size(); i++) {
			bw.write(result.get(i)+"\n");
		}
		bw.flush();
	}
	
	private static void Hanoi(int N, int from, int to, int other) {
		if(N == 0)
			return;
		Hanoi(N-1, from, other, to);
		result.add(from + " " + to);
		Hanoi(N-1, other, to, from);
	}
}
