package backjoon_1929;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] notsosu = new boolean[n+1];

        notsosu[1] = true;
        for(int i = 2; i < n; i++){
            for(int j = 2; j <= n/i; j++){
                notsosu[i*j] = true;
            }
        }

        for(int i = m; i <= n; i++){
            if(!notsosu[i])
                System.out.println(i);
        }
    }
}
