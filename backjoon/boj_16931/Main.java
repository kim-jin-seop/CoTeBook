package boj_16931;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        int area = n * m * 2; //밑, 윗 넓이
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 < 0) {
                    area += paper[i][j];
                } else {
                    if (paper[i - 1][j] < paper[i][j])
                        area += paper[i][j] - paper[i - 1][j];
                }

                if (i + 1 >= n) {
                    area += paper[i][j];
                } else {
                    if (paper[i + 1][j] < paper[i][j])
                        area += paper[i][j] - paper[i + 1][j];
                }

                if (j - 1 < 0) {
                    area += paper[i][j];
                } else {
                    if (paper[i][j - 1] < paper[i][j])
                        area += paper[i][j] - paper[i][j - 1];
                }

                if (j + 1 >= m) {
                    area += paper[i][j];
                } else {
                    if (paper[i][j + 1] < paper[i][j])
                        area += paper[i][j] - paper[i][j + 1];
                }
            }
        }
        System.out.println(area);
    }
}
