package backjoon_1309;

import java.util.Scanner;

public class Main {
    static long[][] dp = new long[100001][3];

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println((dp(n, 0) + dp(n, 1) + dp(n, 2))%9901);
    }

    public static long dp(int num, int location) {
        if (num == 1)
            return 1L;

        if (dp[num][location] != 0)
            return dp[num][location];

        if (location == 0) {
            return dp[num][location] = (dp(num - 1, 0)% 9901 + dp(num - 1, 1)% 9901 + dp(num - 1, 2)% 9901) % 9901;
        } else if (location == 1) {
            return dp[num][location] = (dp(num - 1, 0)% 9901 + dp(num - 1, 2)% 9901) % 9901;
        } else {
            return dp[num][location] = (dp(num - 1, 0)% 9901 + dp(num - 1, 1)% 9901) % 9901;
        }
    }
}