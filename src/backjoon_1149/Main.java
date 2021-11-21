package backjoon_1149;

import java.util.Scanner;

public class Main {
    //R : 0 G : 1 B : 2
    static int[][] dp = new int[1001][3];
    static int[][] value;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        value = new int[num+1][3];

        for (int i = 1; i <= num; i++) {
            value[i][0] = sc.nextInt();
            value[i][1] = sc.nextInt();
            value[i][2] = sc.nextInt();
        }

        // RGB중 최소
        System.out.println(Math.min(Math.min(dp(num, 0), dp(num, 1)), dp(num, 2)));
    }

    public static int dp(int num, int color) {
        if (num == 1)
            return value[num][color];
        if (dp[num][color] != 0)
            return dp[num][color];

        if (color == 0)
            return dp[num][color] = (Math.min(dp(num - 1, 1), dp(num - 1, 2)) + value[num][color]);
        else if (color == 1)
            return dp[num][color] = (Math.min(dp(num - 1, 0), dp(num - 1, 2)) + value[num][color]);
        else
            return dp[num][color] = (Math.min(dp(num - 1, 0), dp(num - 1, 1)) + value[num][color]);
    }
}
