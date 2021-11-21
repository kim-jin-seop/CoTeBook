package backjoon_1157;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String data = new Scanner(System.in).next();
		int[] alp = new int[26];
		
		for(int i = 0; i < data.length(); i ++) {
			if(data.charAt(i) < 97)
				alp[data.charAt(i)-65]++;
			else
				alp[data.charAt(i) -97]++;
		}
		
		int max = 0;
		int maxindex = 0;
		boolean eqflag = false; 
		for(int i =0; i< alp.length; i++) {
			if(max < alp[i]) {
				max = alp[i];
				maxindex = i;
				eqflag = false;
			}
			else if(max == alp[i]) {
				eqflag = true;
			}
		}
		
		if(eqflag)
			System.out.println("?");
		else
			System.out.println((char)(maxindex+65));
	}
}
