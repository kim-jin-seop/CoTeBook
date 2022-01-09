package backjoon_2225;

import java.util.*;

public class Main {
    public static long mod = 1000000000L;
    static long[][] dp = new long[201][201];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long value = dp(n, k);
        System.out.println(value);

    }

    public static long dp(int n, int k){
        if(n ==0 || k == 1)
            return 1;
        if(dp[n][k] != 0)
            return dp[n][k];

        long count = 0L;
        for(int i = 0; i <= n; i++){
            count += dp(n-i,k-1);
            count %= mod;
        }

        dp[n][k] = count;
        return count;
    }
}