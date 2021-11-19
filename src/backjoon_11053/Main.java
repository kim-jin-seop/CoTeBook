package backjoon_11053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n; i++){
            int point = list[i];
            int num = 0;
            for(int j = i; j >= 0; j--){
                if(point > list[j]){
                    num = num > dp[j] ? num : dp[j];
                }
            }
            dp[i] = num + 1;
        }

        int max = 0;
        for(int i = 0; i < n; i++)
            max = dp[i] > max ? dp[i] : max;

        System.out.println(max);
    }
}
