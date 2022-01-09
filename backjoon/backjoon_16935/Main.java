package backjoon_16935;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int calNum = sc.nextInt();

        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < calNum; i++) {
            data = solve(sc.nextInt(),data);
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int num, int[][] data) {
        switch (num) {
            case 1:
                return numA(data);
            case 2:
                return numB(data);
            case 3:
                return numC(data);
            case 4:
                return numD(data);
            case 5:
                return numE(data);
            default:
                return numF(data);
        }
    }

    public static int[][] numA(int[][] data) {
        int[][] resultData = new int[data.length][data[0].length];

        for (int i = 0; i < resultData.length; i++) {
            resultData[i] = data[resultData.length - i - 1];
        }
        return resultData;
    }

    public static int[][] numB(int[][] data) {
        int[][] resultData = new int[data.length][data[0].length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                resultData[i][data[i].length - j - 1] = data[i][j];
            }
        }
        return resultData;
    }

    public static int[][] numC(int[][] data) {
        int[][] resultData = new int[data[0].length][data.length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                resultData[j][data.length - 1 - i] = data[i][j];
            }
        }
        return resultData;
    }

    public static int[][] numD(int[][] data) {
        int[][] resultData = new int[data[0].length][data.length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                resultData[data[i].length - j - 1][i] = data[i][j];
            }
        }
        return resultData;
    }

    public static int[][] numE(int[][] data) {
        int[][] resultData = new int[data.length][data[0].length];
        int halfX = data.length / 2;
        int halfY = data[0].length / 2;

        for (int i = 0; i < halfX; i++) {
            for (int j = 0; j < halfY; j++) {
                resultData[i][j + halfY] = data[i][j];
                resultData[i + halfX][j + halfY] = data[i][j + halfY];
                resultData[i + halfX][j] = data[i + halfX][j + halfY];
                resultData[i][j] = data[i + halfX][j];
            }
        }
        return resultData;
    }

    public static int[][] numF(int[][] data) {
        int[][] resultData = new int[data.length][data[0].length];
        int halfX = data.length / 2;
        int halfY = data[0].length / 2;

        for (int i = 0; i < halfX; i++) {
            for (int j = 0; j < halfY; j++) {
                resultData[i][j + halfY] = data[i + halfX][j + halfY];
                resultData[i + halfX][j + halfY] = data[i + halfX][j];
                resultData[i + halfX][j] = data[i][j];
                resultData[i][j] = data[i][j + halfY];
            }
        }
        return resultData;
    }

}


