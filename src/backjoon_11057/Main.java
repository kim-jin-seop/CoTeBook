package backjoon_11057;

import java.util.Scanner;

public class Main {
    static long[][] dp = new long[1001][10];

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp(num,i);
        }
        System.out.println(sum%10007);
    }

    public static long dp(int num, int last) {
        if(num == 1)
            return 1;
        if(dp[num][last] != 0)
            return dp[num][last];

        long count = 0L;
        for (int i = 0; i <= last; i++) {
            count += dp(num - 1, i) % 10007;
        }
        return dp[num][last]  = count % 10007;
    }
}
