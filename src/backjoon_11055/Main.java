package backjoon_11055;

import java.util.Scanner;

public class Main {
    static int[] value;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        value = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; i ++)
            value[i] = sc.nextInt();

        for(int i = 0; i< n; i++)
            solve(i);

        int max = dp[0];
        for(int i=1; i < n; i++){
            max = max > dp[i] ? max : dp[i];
        }
        System.out.println(max);
    }

    public static int solve(int idx){
        int max = value[idx];
        if(dp[idx] != 0){
            return dp[idx];
        }

        for(int i = idx; i >= 0; i--){
            if(value[idx] > value[i]){
                int diff = solve(i);
                max = value[idx] + diff > max ? value[idx] + diff : max;
            }
        }
        return dp[idx] = max;
    }
}
