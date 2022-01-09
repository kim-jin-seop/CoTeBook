package backjoon_11722;

import java.util.Scanner;

public class Main {
    static int[] value;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        value = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();

        int max = 0;
        for(int i = 0; i< n; i++){
            int len = solve(i);
            max = max > len ? max : len;
        }

        System.out.println(max);
    }

    public static int solve(int idx) {
        if (dp[idx] != 0)
            return dp[idx];

        int max = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if (value[idx] < value[i]) {
                int findLength = solve(i);
                if (findLength > max)
                    max = findLength;
            }
        }
        return dp[idx] = max + 1;
    }
}
