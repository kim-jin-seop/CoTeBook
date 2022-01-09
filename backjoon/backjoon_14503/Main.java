package backjoon_14503;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int[] north = {-1, 0};
        final int[] east = {0, 1};
        final int[] south = {1, 0};
        final int[] west = {0, -1};

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int direction = sc.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        boolean[][] clean = new boolean[m][n];

        int cleanCount = 0;
        int check = 0;
        while (true) {
            //step 1
            if (!clean[r][c]) {
                clean[r][c] = true;
               cleanCount++;
            }
            //step2,a
            int[] left = direction == 0 ? west : direction == 1 ? north : direction == 2 ? east : south;
            if (!clean[r + left[0]][c + left[1]] && map[r + left[0]][c + left[1]] == 0) {
                direction = (direction + 3) % 4;
                r = r + left[0];
                c = c + left[1];
                check = 0;
                continue;
            }
            else if(check == 4){ //c,d
                check = 0;
                int[] back = direction == 0 ? south : direction == 1 ? west : direction == 2 ? north : east;
                if(map[r+back[0]][c+back[1]] == 0){ //c
                    r += back[0];
                    c += back[1];
                }
                else{ //d
                    break;
                }
            }
            else{ //b
                direction = (direction + 3) % 4;
                check ++;
                continue;
            }
        }
        System.out.println(cleanCount);
    }

}
