package backjoon_14391;

import java.util.Scanner;

public class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] num = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                num[i][j] = s.charAt(j) - '0';
            }
        }
        recursive(num,new boolean[n][m],n,m,0,0);
        System.out.println(max);
    }

    //재귀 - 어떤거 쓸지
    public static void recursive(int[][] num, boolean[][] paper, int n, int m, int xIdx, int yIdx){
        if(yIdx == m){
            int sum = 0;
            for(int i = 0; i < n; i++){
                int cur = 0;
                for(int j = 0; j <m; j++){
                    if(paper[i][j]){
                        cur = cur*10 + num[i][j];
                    }
                    else{
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for(int j = 0; j < m; j++ ){
                int cur = 0;
                for(int i = 0; i < n; i++){
                    if(!paper[i][j]){
                        cur = cur*10 + num[i][j];
                    }
                    else{
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            if(max < sum){
                max = sum;
            }
            return;
        }
        paper[xIdx][yIdx] = true;
        if(xIdx == n-1){
            recursive(num,paper,n,m,0,yIdx+1);
        }
        else {
            recursive(num, paper, n, m, xIdx + 1, yIdx);
        }
        paper[xIdx][yIdx] = false;
        if(xIdx == n-1){
            recursive(num,paper,n,m,0,yIdx+1);
        }
        else {
            recursive(num, paper, n, m, xIdx + 1, yIdx);
        }
    }
}

