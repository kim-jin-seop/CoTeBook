package backjoon_15649;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        find(n,m,"");
    }

    public static void find(int n, int m, String result) {
        if (m == 0) {
            System.out.println(result);
            return;
        }
        for (int i = 1; i <= n; i++) {
            String input = result + i + " ";
            if(!result.contains(String.valueOf(i)))
                find(n, m - 1, input);
        }
    }
}
