package knu_goricon_open_contest;

import java.util.Scanner;

public class problemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] dp = new int[num];
        int[] value = new int[num];
        int[] list = new int[num];

        for(int i = 0; i < num; i++){
            list[i] = sc.nextInt();
        }

        dp[0] = 1;
        value[0] = list[0];
        for(int i = 1; i < num; i++){
            int max = Integer.MIN_VALUE;
            int val = 0;
            for(int j = i-1; j >= 0; j--){
                int count = 1;
                if((value[j]&list[i]) != 0){
                    count += dp[j];
                }
                if(count > max){
                    val = value[j] & list[i];
                    max = count;
                }
            }
            value[i] = val;
            dp[i] = max;
        }

        int findMax = Integer.MIN_VALUE;
        for(int i = 0; i < num; i++){
            findMax = Math.max(findMax,dp[i]);
        }
        System.out.println(findMax);
    }
}
