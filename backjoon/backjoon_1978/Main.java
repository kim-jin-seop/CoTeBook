package backjoon_1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            boolean isSosu = true;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    isSosu = false;
                    break;
                }
            }
            if (isSosu&& num != 1)
                count++;
        }
        System.out.println(count);
    }
}
