package backjoon_10844;

import java.util.Scanner;

public class Main {
    static int[][] result = new int[101][10];

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        int sum = 0;
        for(int i = 1; i < 10; i++)
            sum = (sum + solve(num-1,i)) % 1000000000;
        System.out.println(sum % 1000000000);

    }

    public static int solve(int num, int now){
        if(num == 0)
            return 1;

        int next = now + 1;
        int prev = now - 1;
        if(result[num][now] != 0)
            return result[num][now];

        int sum = 0;
        if(next != 10)
            sum += solve(num-1,next);
        if(prev != -1)
            sum += solve(num-1,prev);
        return result[num][now] = sum % 1000000000;
    }
}
