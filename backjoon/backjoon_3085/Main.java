package backjoon_3085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 != n) {
                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                    max = findMax(board, n, max);
                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }
                if (i + 1 != n) {
                    char temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                    max = findMax(board, n, max);
                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }
            }
        }
        System.out.println(max);
    }

    private static int findMax(char[][] board, int n, int max) {
        for (int i = 0; i < n; i++) {
            char prev = board[i][0];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (prev == board[i][j]) {
                    count++;
                } else {
                    max = count > max ? count : max;
                    prev = board[i][j];
                    count = 1;
                }
            }
            max = count > max ? count : max;

            count = 0;
            prev = board[0][i];
            for(int j = 0; j < n; j++){
                if(prev == board[j][i]){
                    count++;
                }else {
                    max = count > max ? count : max;
                    prev = board[j][i];
                    count = 1;
                }
            }
            max = count > max ? count : max;
        }
        return max;
    }
}
