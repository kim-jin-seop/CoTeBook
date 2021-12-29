package backjoon_15685;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        boolean[][] location = new boolean[101][101];
        int curveSize = sc.nextInt();

        while (curveSize-- != 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            ArrayList<Integer> directions = new ArrayList<>();
            directions.add(d);
            if(g != 0)
                findDirection(g, directions);
            makeCurve(location, x, y, directions);
        }

        int count = countingSquare(location);
        System.out.println(count);
    }

    private static void makeCurve(boolean[][] location, int x, int y, ArrayList<Integer> directions) {
        //첫 점
        location[x][y] = true;
        for (int i = 0; i < directions.size(); i++) {
            int direction = directions.get(i);
            if (direction == 0) {
                x += 1;
            } else if (direction == 1) {
                y -= 1;
            } else if (direction == 2) {
                x -= 1;
            } else {
                y += 1;
            }
            if (x >= 0 && y >= 0 && x < location.length && y < location.length) {
                location[x][y] = true;
            } else
                break;
        }
    }

    private static void findDirection(int g, ArrayList<Integer> directions) {
        for (int i = directions.size() - 1; i >= 0; i--) {
            directions.add((directions.get(i) + 1) % 4);
        }
        if (g > 1)
            findDirection(g - 1, directions);
    }


    private static int countingSquare(boolean[][] location) {
        int[] dx = {0, 0, 1, 1};
        int[] dy = {0, 1, 0, 1};
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int k = 0;
                for (; k < 4; k++) {
                    if (!location[i + dx[k]][j + dy[k]])
                        break;
                }
                if (k == 4)
                    count++;
            }
        }
        return count;
    }
}
