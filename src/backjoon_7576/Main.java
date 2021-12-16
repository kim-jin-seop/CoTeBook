package backjoon_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] storage = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                storage[i][j] = sc.nextInt();
            }
        }

        int[][] check = new int[n][m];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                    check[i][j] = 1;
                }
                if(storage[i][j] == -1)
                    check[i][j] = -1;
            }
        }

        while (!queue.isEmpty()) {
            bfs(queue, check, storage);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0) {
                    max = -2;
                    break;
                }
                if (check[i][j] > max)
                    max = check[i][j];
            }
            if (max == -2)
                break;
        }

        if (max == -2)
            System.out.println(-1);
        else
            System.out.println(max == -1 ? 0 : max - 1);
    }

    static void bfs(Queue<Integer> queue, int[][] check, int[][] storage) {
        int[] dFirst = {1, -1, 0, 0};
        int[] dSecond = {0, 0, 1, -1};
        int first = queue.remove();
        int second = queue.remove();

        for (int i = 0; i < 4; i++) {
            if (first + dFirst[i] >= 0 && first + dFirst[i] < check.length
                    && second + dSecond[i] >= 0 && second + dSecond[i] < check[first].length) {
                if (check[first + dFirst[i]][second + dSecond[i]] == 0) {
                    queue.add(first + dFirst[i]);
                    queue.add(second + dSecond[i]);
                    check[first + dFirst[i]][second + dSecond[i]] = check[first][second] + 1;
                }
            }
        }
    }
}
