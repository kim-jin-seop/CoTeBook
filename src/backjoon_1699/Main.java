package backjoon_1699;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dp = new int[100001];
        int num = new Scanner(System.in).nextInt();

        for(int i = 1; i <= num; i++){
            int sqrt = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for(int j = sqrt; j > 0 ; j --){
                int value = i - j*j;
                int count = 1;
                if(value != 0) {
                    count += dp[value];
                }
                if(min > count){
                    min = count;
                }
            }
            dp[i] = min;
        }
        System.out.println(dp[num]);
    }
}
