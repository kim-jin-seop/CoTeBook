package backjoon_11054;

import java.util.Scanner;

public class Main {
    static int[] value;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        value = new int[n];
        dp = new int[n][2];

        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int len = solveUp(i);
            max = max > len? max : len;
        }

        for(int i = 0; i < n; i++){
            int len = solveDown(i);
            max = max > len? max : len;
        }
        System.out.println(max);
    }

    private static int solveDown(int idx) {
        if(dp[idx][1] != 0)
            return dp[idx][1];

        int max = 0;
        for (int i = idx; i >= 0; i--) {
            if (value[idx] < value[i]) {
                int findUpLen = solveUp(i);
                int findDownLen = solveDown(i);
                int findLen = findDownLen > findUpLen ? findDownLen : findUpLen;
                max = max > findLen ? max : findLen;
            }
        }
        return dp[idx][1] = max + 1;
    }

    public static int solveUp(int idx) {
        if (dp[idx][0] != 0)
            return dp[idx][0];

        int max = 0;
        for (int i = idx; i >= 0; i--) {
            if (value[idx] > value[i]) {
                int findLen = solveUp(i);
                max = max > findLen ? max : findLen;
            }
        }
        return dp[idx][0] = max + 1;
    }
}
