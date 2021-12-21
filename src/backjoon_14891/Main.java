package backjoon_14891;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int sawLength = 8;
        Gear[] gears = new Gear[4];

        for (int i = 0; i < 4; i++) {
            int[] sawTooth = new int[sawLength];
            String line = sc.next();
            for (int j = 0; j < sawLength; j++) {
                sawTooth[j] = line.charAt(j) - '0';
            }
            gears[i] = new Gear(sawTooth);
        }

        int moveCount = sc.nextInt();
        while (moveCount-- > 0) {
            int gearNum = sc.nextInt();
            int movement = sc.nextInt();
            IterMovement(gearNum - 1, movement, gears);
        }

        int count = 0;

        for (int i = 0; i < 4; i++) {
            if (gears[i].getTwelveSawTooth() == 1)
                if (i == 0)
                    count += 1;
                else if (i == 1)
                    count += 2;
                else if (i == 2)
                    count += 4;
                else
                    count += 8;

        }
        System.out.println(count);
    }

    public static void IterMovement(int gearNum, int movement, Gear[] gears) {
        int left = gears[gearNum].getLeftSawTooth();
        int right = gears[gearNum].getRightSawTooth();
        movement(gearNum, movement, gears);

        int move = movement;
        for (int i = gearNum - 1; i >= 0; i--) {
            int getLeftSawTooth = gears[i].getRightSawTooth();
            if (left != getLeftSawTooth) {
                left = gears[i].getLeftSawTooth();
                movement(i, move *= -1, gears);
            } else {
                break;
            }
        }

        move = movement;
        for (int i = gearNum + 1; i < gears.length; i++) {
            int getRightSawTooth = gears[i].getLeftSawTooth();
            if (right != getRightSawTooth) {
                right = gears[i].getRightSawTooth();
                movement(i, move *= -1, gears);
            } else {
                break;
            }
        }
    }

    private static void movement(int gearNum, int movement, Gear[] gears) {
        if (movement == 1) {
            gears[gearNum].moveRight();
        } else {
            gears[gearNum].moveLeft();
        }
    }


    public static class Gear {
        private int[] sawTooth;
        private int sawLength;
        private int startIndex;

        public Gear(int[] sawTooth) {
            startIndex = 6;
            this.sawTooth = sawTooth;
            sawLength = 8;
        }

        public int getLeftSawTooth() {
            return sawTooth[startIndex];
        }

        public int getRightSawTooth() {
            return sawTooth[(startIndex + sawLength / 2) % sawLength];
        }

        public int getTwelveSawTooth() {
            return sawTooth[(startIndex + sawLength / 4) % sawLength];
        }

        public void moveLeft() {
            startIndex += 1;
            startIndex %= sawLength;
        }

        public void moveRight() {
            startIndex += sawLength - 1;
            startIndex %= sawLength;
        }
    }
}

