package backjoon_10814;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
		
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			String[] sp = data.split(" ");
			
			ArrayList<String> list = map.containsKey(Integer.parseInt(sp[0])) ? map.get(Integer.parseInt(sp[0])) : new ArrayList<String>();
			list.add(sp[1]);
			map.put(Integer.parseInt(sp[0]),list);
		}
		
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext()) {
			int key = (int)iter.next();
			ArrayList<String> list = map.get(key);
			while(!list.isEmpty()) {
				bw.write(key+" "+list.remove(0)+"\n");
			}
		}
		bw.flush();
	}
}
