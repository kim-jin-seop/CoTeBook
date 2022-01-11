package boj_16197;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] board = new char[n][m];
        int[][] coins = new int[2][2];

        int coinCheck = 0;
        for(int i = 0; i < n; i++){
            String input = sc.next();
            for(int j = 0; j < m; j++){
                board[i][j] = input.charAt(j);
                if(input.charAt(j) =='o'){
                    coins[coinCheck][0] = i;
                    coins[coinCheck][1] = j;
                    coinCheck++;
                }
            }
        }
        if(coinCheck == 2) {
            int resultValue = moveCoin(board, coins, 0);
            if (resultValue == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(resultValue);
            }
        }
        else
            System.out.println(-1);
    }

    public static int moveCoin(char[][] board, int[][] coins, int cnt){
        if(coins[0][0] < 0 || coins[0][0] >= board.length || coins[0][1] < 0 || coins[0][1] >= board[0].length){
            if(coins[1][0] < 0 || coins[1][0] >= board.length || coins[1][1] < 0 || coins[1][1] >= board[0].length)
                return -1;
            return cnt;
        }
        if(coins[1][0] < 0 || coins[1][0] >= board.length || coins[1][1] < 0 || coins[1][1] >= board[0].length){
            return cnt;
        }
        if(cnt == 10 || (coins[0][0] == coins[1][0] && coins[0][1] == coins[1][1])){
            return -1;
        }
        // 0 : 북 1 : 동 2 : 남 3 : 서 시계방향
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            boolean coinOneMove = true;
            boolean coinTwoMove = true;
            coins[0][0] += dx[i];
            coins[0][1] += dy[i];
            coins[1][0] += dx[i];
            coins[1][1] += dy[i];

            if(!(coins[0][0] < 0 || coins[0][0] >= board.length || coins[0][1] < 0 || coins[0][1] >= board[0].length)
                    && board[coins[0][0]][coins[0][1]] == '#'){
                coinOneMove = false;
                coins[0][0] -= dx[i];
                coins[0][1] -= dy[i];
            }
            if(!(coins[1][0] < 0 || coins[1][0] >= board.length || coins[1][1] < 0 || coins[1][1] >= board[0].length)
                    && board[coins[1][0]][coins[1][1]] == '#'){
                coinTwoMove = false;
                coins[1][0] -= dx[i];
                coins[1][1] -= dy[i];
            }

            int value = moveCoin(board, coins, cnt + 1);
            if(value != -1){
                min = Math.min(value,min);
            }
            if(coinOneMove) {
                coins[0][0] -= dx[i];
                coins[0][1] -= dy[i];
            }
            if(coinTwoMove) {
                coins[1][0] -= dx[i];
                coins[1][1] -= dy[i];
            }
        }
        return min;
    }
}
