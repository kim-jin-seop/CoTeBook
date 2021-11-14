package backjoon_11727;

import java.util.Scanner;

public class Main {
    static int[] result = new int[1001];
    public static void main(String[] args) {
        System.out.println(recursive(new Scanner(System.in).nextInt()));
    }

    public static int recursive(int num){
        if(num == 1)
            return 1;
        if(num == 2)
            return 3;
        if(result[num] != 0)
            return result[num];

        return result[num] = (recursive(num-1) + 2*recursive(num-2))%10007;
    }
}
