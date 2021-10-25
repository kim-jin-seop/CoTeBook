package backjoon_9095;

import java.util.Scanner;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            System.out.println(find(sc.nextInt(),0));
        }
    }

    public static int find(int num, int minus){
        if(num == minus){
            return 1;
        }
        num = num - minus;
        if(num < 0)
            return 0;
        int sum = 0;
        for(int i = 1; i <= 3; i++){
            sum += find(num,i);
        }
        return sum;
    }
}
