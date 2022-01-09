package backjoon_18290;

import java.util.Scanner;

public class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        boolean[][] check = new boolean[n][m];
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solve(check,board,0,k,0);
        System.out.println(max);

    }

    public static void solve(boolean[][] check, int[][] board, int cnt, int k, int sum) {
        if (cnt == k) {
            if(max < sum)
                max = sum;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check[i][j] || (i != 0 && check[i - 1][j]) || (i != board.length - 1 && check[i + 1][j]) || (j != 0 && check[i][j - 1]) || (j != board[i].length - 1 && check[i][j + 1]))
                    continue;
                check[i][j] = true;
                sum += board[i][j];
                solve(check,board,cnt+1,k,sum);
                check[i][j] = false;
                sum -= board[i][j];
            }
        }
    }
}
