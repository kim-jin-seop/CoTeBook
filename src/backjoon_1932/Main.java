package backjoon_1932;

import java.util.Scanner;

public class Main {
    static int[][] dp = new int[501][501];
    static int[][] triangle;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();

        triangle = new int[height][height];

        for(int i = 0; i < height; i++){
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        int max = findMax(0,0);
        System.out.println(max);
    }

    public static int findMax(int height, int index){
        if(height == triangle.length){
            return 0;
        }
        if(dp[height][index] != 0)
            return dp[height][index];
       int max = Math.max(findMax(height+1,index),findMax(height+1,index+1)) + triangle[height][index];
       dp[height][index] = max;
       return max;
    }
}
