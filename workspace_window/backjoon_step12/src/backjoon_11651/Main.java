package backjoon_11651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Location[] data = new Location[N];
		for(int i = 0; i < N; i ++) {
			String d = br.readLine();
			String[] cut = d.split(" ");
			data[i] = new Location(Integer.parseInt(cut[0]),Integer.parseInt(cut[1]));
		}
		
		Arrays.sort(data, new Comparator<Location>() {
			@Override
			public int compare(Location d1, Location d2) {
				int diff = d1.Y - d2.Y;
				return diff != 0 ? diff : d1.X - d2.X;
			}
		});
		
		for(int i = 0; i < N; i++) {
			bw.write(data[i].X + " " + data[i].Y + "\n");
		}
		bw.flush();
	}
	
	public static class Location{
		int X;
		int Y;
		
		public Location(int x, int y) {
			X = x;
			Y = y;
		}
	}
}
