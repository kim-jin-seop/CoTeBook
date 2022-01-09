package backjoon_1748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int num = 1;
        int result = 0;

        for(int count = 9; input > 0; count *= 10){
            if(input >= count){
                result += count*num;
                input -= count;
            }
            else{
                result += input*num;
                input = 0;
            }
            num++;
        }

        System.out.println(result);

    }
}
