package backjoon_6588;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000000;
        boolean[] notSosu = new boolean[n + 1];

        for (int i = 2; i < n; i++) {
            for (int j = 2; i * j <= n; j++)
                notSosu[i * j] = true;
        }

        int input;
        while ((input = sc.nextInt()) != 0) {
            boolean find = false;
            for (int i = 2; i < input && !find; i++) {
                if (!notSosu[i]) {
                    for (int j = input - 2; j >= i; j--) {
                        if (notSosu[j])
                            continue;
                        if (i + j == input) {
                            find = true;
                            System.out.println(input + " = " + i + " + " + j);
                            break;
                        } else if (i + j < input)
                            break;
                    }
                }
            }
            if (!find)
                System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}
