package backjoon_1476;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 1;
        int s = 1;
        int m = 1;
        int year = 1;

        while (true) {
            if (E == e && S == s && M == m) {
                System.out.println(year);
                break;
            }

            e = (e + 1) % 16 == 0 ? 1 : (e + 1) % 16;
            s = (s + 1) % 29 == 0 ? 1 : (s + 1) % 29;
            m = (m + 1) % 20 == 0 ? 1 : (m + 1) % 20;
            year++;
        }
    }
}
