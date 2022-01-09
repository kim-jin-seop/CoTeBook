package backjoon_13398;

import java.util.Scanner;

public class Main {
    static int[] value;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        value = new int[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++)
            value[i] = sc.nextInt();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sol = solvePre(i);
            max = max > sol ? max : sol;
        }
        for (int i = n; i >= 1; i--) {
            solvePost(i);
        }

        for (int i = 2; i <= n-1; i++) {
            int removeI = solvePre(i-1) + solvePost(i+1);
            max = max > removeI ? max : removeI;
        }
        System.out.println(max);
    }

    public static int solvePre(int idx) {
        if (idx == 0)
            return 0;

        if (dp[idx][0] != 0) {
            return dp[idx][0];
        }

        int prev = solvePre(idx - 1);
        int result = value[idx];
        if (prev + value[idx] > value[idx])
            result = prev + value[idx];
        return dp[idx][0] = result;
    }

    public static int solvePost(int idx) {
        if (idx == dp.length)
            return 0;

        if (dp[idx][1] != 0) {
            return dp[idx][1];
        }

        int post = solvePost(idx + 1);
        int result = value[idx];
        if (post + value[idx] > value[idx])
            result = post + value[idx];
        return dp[idx][1] = result;
    }
}
