package backjoon_9095;

import java.util.Scanner;

public class Main_DP {
    static int[] result = new int[12];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
            System.out.println(recursion(sc.nextInt()));
    }

    public static int recursion(int num){
        if(num == 1)
            return 1;
        else if(num == 2)
            return 2;
        else if(num == 3)
            return 4;
        if(result[num] != 0)
            return result[num];

        return result[num] = recursion(num-1) + recursion(num-2) + recursion(num-3);
    }
}
