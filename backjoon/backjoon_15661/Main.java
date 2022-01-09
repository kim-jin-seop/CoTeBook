package backjoon_15661;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] t = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = sc.nextInt();
            }
        }

        find(new ArrayList<>(), new ArrayList<>(), t, n, 0);
        System.out.println(min);
    }

    public static void find(ArrayList<Integer> startTeam, ArrayList<Integer> LinkTeam, int[][] t, int n, int index) {
        if (n == index) {
            int a = 0;
            int b = 0;
            if (startTeam.size() == n || LinkTeam.size() == n)
                return;
            for (int i = 0; i < startTeam.size(); i++) {
                for (int j = 0; j < startTeam.size(); j++) {
                    a += t[startTeam.get(i)][startTeam.get(j)];
                }
            }
            for (int i = 0; i < LinkTeam.size(); i++) {
                for (int j = 0; j < LinkTeam.size(); j++) {
                    b += t[LinkTeam.get(i)][LinkTeam.get(j)];
                }
            }
            if (min > Math.abs(a - b))
                min = Math.abs(a - b);
            return;
        }
        startTeam.add(index);
        find(startTeam, LinkTeam, t, n, index + 1);
        startTeam.remove(Integer.valueOf(index));
        LinkTeam.add(index);
        find(startTeam,LinkTeam,t,n,index+1);
        LinkTeam.remove(Integer.valueOf(index));
    }
}