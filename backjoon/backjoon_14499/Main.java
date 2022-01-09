package backjoon_14499;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int firstX = sc.nextInt();
        int firstY = sc.nextInt();
        int commandCount = sc.nextInt();
        int[][] map = new int[n][m];
        int[] dice = new int[6];
        int[] commands = new int[commandCount];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < commandCount; i++){
            commands[i] = sc.nextInt();
        }

        dice[5] = map[firstX][firstY];
        map[firstX][firstY] = 0;
        command(commands,firstX,firstY,map,dice);
    }


    public static void command(int[] commands, int locationX, int locationY, int map[][], int[] dice) {
        for (int command : commands) {
            boolean isChange = false;
            if (command == 1 && locationY + 1 < map[0].length) {
                int temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                locationY++;
                isChange = true;

            } else if (command == 2 && locationY > 0) {
                int temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                locationY--;
                isChange = true;
            } else if (command == 3 && locationX > 0) {
                int temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                locationX--;
                isChange = true;
            } else if (command == 4 && locationX + 1 < map.length) {
                int temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                locationX++;
                isChange= true;
            }
            if(isChange) {
                if (map[locationX][locationY] == 0)
                    map[locationX][locationY] = dice[5];
                else {
                    dice[5] = map[locationX][locationY];
                    map[locationX][locationY] = 0;
                }
                System.out.println(dice[0]);
            }
        }
    }
}
