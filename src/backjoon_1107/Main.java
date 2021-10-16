package backjoon_1107;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        boolean[] melfunc = new boolean[10];
        for (int i = 0; i < m; i++) {
            melfunc[sc.nextInt()] = true;
        }

        int start = 100;
        int min = Math.abs(N-start);

        for (int i = 0; i < 1000000; i++) {
            int check = i;
            boolean skip = false;
            boolean endFlag = false;
            int count = 0;
            while (!endFlag) {
                if (0 <= check && check < 10)
                    endFlag = true;
                if (melfunc[check % 10]) {
                    skip = true;
                    break;
                }
                count++;
                check = check / 10;
            }
            if (skip)
                continue;

            min = min > Math.abs(i - N) + count ? Math.abs(i - N) + count : min;
        }
        System.out.println(min);
    }
}
