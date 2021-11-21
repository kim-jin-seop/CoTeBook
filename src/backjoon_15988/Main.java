package backjoon_15988;

import java.util.Scanner;

public class Main {
    static long[] dp = new long[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0){
            int n = sc.nextInt();
            long dp = dp(n);
            System.out.println(dp);
        }
    }

    public static long dp(int num){
        if(num == 1)
            return 1;
        else if(num == 2)
            return 2;
        else if(num == 3)
            return 4;

        if(dp[num] != 0)
            return dp[num];
        long value = (dp(num-1) + dp(num-2) + dp(num-3))%1000000009;
        return dp[num] = value ;
    }
}
