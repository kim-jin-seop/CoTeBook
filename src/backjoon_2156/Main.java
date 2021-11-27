package backjoon_2156;

import java.util.Scanner;

public class Main {
    static int[] wine;
    static int[] dp = new int[10001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        wine = new int[n+1];

        for(int i = 1; i <= n; i++)
            wine[i] = sc.nextInt();

        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int continueZero = dp[i-1];
            int continueOne = i > 1 ? dp[i-2] + wine[i] : wine[i];
            int continueTwo = i > 2 ? dp[i-3] + wine[i] + wine[i-1] : i == 2 ? wine[i] + wine[i-1] : 0;
            int max = Math.max(Math.max(continueOne,continueTwo),continueZero);
            dp[i] = max;
        }

        System.out.println(dp[n]);
    }
}
