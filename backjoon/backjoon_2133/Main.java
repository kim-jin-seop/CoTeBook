package backjoon_2133;

import java.util.Scanner;

public class Main {
    static int[] dp = new int[31];
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        if(num % 2 == 0)
            System.out.println(solution(num));
        else
            System.out.println(0);
    }

    public static int solution(int num){
        if(num == 0)
            return 1;
        if(dp[num] != 0)
            return dp[num];

        int result = solution(num-2) * 3;
        for(int i = 2; i <= num/2; i++){
            result += solution(num-2*i) * 2;
        }
        return dp[num] = result;
    }
}
