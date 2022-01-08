package boj_16198;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> w = new ArrayList<>();

        for(int i = 0; i < n; i++){
            w.add(sc.nextInt());
        }

        recurSolve(w,0);

        System.out.println(max);

    }

    public static void recurSolve(ArrayList<Integer> w, int energy){
        if(w.size() == 2){
            if(energy > max){
                max = energy;
            }
            return;
        }

        for(int i = 1; i < w.size()-1; i++){
            Integer removeValue = w.get(i);
            int aVal = w.get(i-1);
            int bVal = w.get(i+1);
            w.remove(i);
            recurSolve(w,energy+aVal*bVal);
            w.add(i,removeValue);
        }
    }

}
