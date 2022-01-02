package boj_16967;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] b = new int[h+x][w+y];
        for(int i = 0; i <h+x; i++){
            for(int j = 0; j < w+y; j++){
                b[i][j] = sc.nextInt();
            }
        }

        int[][] a = new int[h][w];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < w; j++){
                a[i][j] = b[i][j];
            }
        }

        for(int i = x; i < h; i++){
            for(int j = 0; j < y; j++){
                a[i][j] = b[i][j];
            }
        }

        for(int i = x; i < h; i++){
            for(int j = y; j < w; j++){
                a[i][j] = b[i][j] - a[i-x][j-y];
            }
        }

        for(int i = 0 ; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
