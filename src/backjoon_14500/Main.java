package backjoon_14500;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j < m - 3) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i][j + 3], max);
                }
                if (i < n - 3) {
                    max = Math.max(board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 3][j], max);
                }

                if (i < n - 1 && j < m - 1) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1], max);
                }

                if (i < n - 2 && j < m - 1) {
                    max = Math.max(board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 2][j + 1], max);
                }
                if (i < n - 1 && j < m - 2) {
                    max = Math.max(board[i][j] + board[i + 1][j] + board[i][j + 1] + board[i][j + 2], max);
                }
                if (i < n - 2 && j < m - 1) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1], max);
                }
                if (i > 0 && j < m - 2) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i - 1][j + 2], max);
                }
                if (i < n - 2 && j < m - 1) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 2][j], max);
                }
                if (i < n - 1 && j < m - 2) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 2], max);
                }
                if (i > 1 && j < m - 1) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i - 1][j + 1] + board[i - 2][j + 1], max);
                }
                if (i < n - 1 && j < m - 2) {
                    max = Math.max(board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2], max);
                }

                if (i < n - 2 && j < m - 1) {
                    max = Math.max(board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 2][j + 1], max);
                }
                if (i > 0 && j < m - 2) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i - 1][j + 1] + board[i - 1][j + 2], max);
                }
                if (i > 1 && j < m - 1) {
                    max = Math.max(board[i][j] + board[i - 1][j] + board[i - 1][j + 1] + board[i - 2][j + 1], max);
                }
                if (i < n - 1 && j < m - 2) {
                    max = Math.max(board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j + 2], max);
                }

                if(i < n-1 && j < m-2){
                    max = Math.max(board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+1], max);
                }
                if(i < n-2 && j > 0){
                    max = Math.max(board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j-1],max);
                }
                if(i > 0 && j < m-2){
                    max = Math.max(board[i][j] + board[i][j+1] + board[i][j+2] + board[i-1][j+1],max );
                }
                if(i < n-2 && j < m-1){
                    max = Math.max(board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j+1],max);
                }
            }
        }
        System.out.println(max);
    }

}