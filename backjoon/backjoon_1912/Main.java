package backjoon_1912;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i< n; i++){
            d[i] = sc.nextInt();
        }
        dp[0] = d[0];
        for(int i = 1; i < n; i++){
            if(dp[i-1] + d[i] < d[i])
                dp[i] = d[i];
            else
                dp[i] = dp[i-1]+d[i];
        }

        int max = dp[0];
        for(int i = 0; i < n; i++){
            if(dp[i] > max)
                max = dp[i];
        }
        System.out.println(max);
    }
}
