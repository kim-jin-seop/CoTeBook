package backjoon_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while ((testCase--) != 0){
            int chessLen = sc.nextInt();
            int[][] board = new int[chessLen][chessLen];
            for(int i = 0; i < chessLen; i++){
                for(int j = 0; j < chessLen; j++){
                    board[i][j] = -1;
                }
            }
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int finishX = sc.nextInt();
            int finishY = sc.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            queue.add(startX);
            queue.add(startY);
            board[startX][startY] = 0;

            while (!queue.isEmpty()){
                bfs(queue,board);
            }
            System.out.println(board[finishX][finishY]);
        }
    }

    public static void bfs(Queue<Integer> queue, int[][] board){
        int X = queue.remove();
        int Y = queue.remove();
        int[] dX = {-2,-1,1,2,2,1,-1,-2};
        int[] dY = {1,2,2,1,-1,-2,-2,-1};

        for(int i = 0; i < 8; i++){
            if(X + dX[i] >= 0 && X + dX[i] < board.length &&
                    Y + dY[i] >= 0 && Y + dY[i] < board.length){
                if(board[X+dX[i]][Y+dY[i]] == -1) {
                    queue.add(X + dX[i]);
                    queue.add(Y + dY[i]);
                    board[X + dX[i]][Y + dY[i]] = board[X][Y] + 1;
                }
            }
        }
    }
}
