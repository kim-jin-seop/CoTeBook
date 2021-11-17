package backjoon_2193;

import java.util.Scanner;

public class Main {
    public static long[][] value = new long[91][2];

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        long result = solve(num,0) + solve(num,1);
        System.out.println(result);
    }

    public static long solve(int num, int now){
        if(num == 1 && now == 1)
            return 1L;
        else if(num == 1 && now == 0)
            return 0L;

        if(value[num][now] != 0)
            return value[num][now];

        long sum = 0L;
        sum += solve(num-1,0);
        if(now != 1)
            sum+= solve(num-1,1);
        return value[num][now] = sum;
    }
}
