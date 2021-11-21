package backjoon_1181;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
		for(int i = 0; i < N; i ++) {
			String input = br.readLine();
			ArrayList<String> array = map.containsKey(input.length()) ? map.get(input.length()) : new ArrayList<String>();
			if(!array.contains(input))
				array.add(input);	
			map.put(input.length(),array);
		}
		
		for(Iterator iter = map.keySet().iterator();iter.hasNext();) {
			ArrayList<String> list = map.get(iter.next());
			list.sort(new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					int diff = 0;
					for(int i = 0; diff == 0; i++) {
						diff = s1.charAt(i) - s2.charAt(i);
					}
					return diff;
				}
			});
			
			while(!list.isEmpty())
				bw.write(list.remove(0) + "\n");
		}
		bw.flush();
	}
}
