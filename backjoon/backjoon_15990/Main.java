package backjoon_15990;

import java.util.Scanner;

public class Main {
    static long[][] result = new long[100001][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int num = sc.nextInt();
            System.out.println((recursive(num,1) + recursive(num,2) + recursive(num,3))%1000000009L);
        }
    }

    public static long recursive(int num, int now) {
        if(num == now)
            return 1;
        if(num < now)
            return 0;
        if(result[num][now] != 0)
            return result[num][now];

        long findOne = 0;
        long findTwo = 0;
        long findThree = 0;
        if(now == 1){
            findOne = (recursive(num - 1, 2) + recursive(num - 1, 3))%1000000009L;
        }
        else if(now == 2){
            findTwo = (recursive(num-2,1) + recursive(num-2, 3))%1000000009L;
        }
        else if(now == 3){
            findThree = (recursive(num-3,1) + recursive(num-3,2))%1000000009L;
        }
        return result[num][now] = (findOne + findTwo + findThree) %1000000009L;
    }
}
