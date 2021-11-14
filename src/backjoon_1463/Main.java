package backjoon_1463;

import java.util.Scanner;

public class Main {
    private static int[] resultArray = new int[1000001];
    public static void main(String[] args) {
        int minValue = recurNum(new Scanner(System.in).nextInt());
        System.out.println(minValue);
    }

    public static int recurNum(int num){
        if(num == 1)
            return 0;
        if(resultArray[num] != 0)
            return resultArray[num];

        int divThree = Integer.MAX_VALUE;
        int divTwo = Integer.MAX_VALUE;
        int minOne;

        if(num % 3 == 0){
            divThree = recurNum(num/3) + 1;
        }
        if(num % 2 == 0){
            divTwo = recurNum(num/2) + 1;
        }
        minOne = recurNum(num -1) + 1;
        return resultArray[num] = Math.min(Math.min(divThree,divTwo),minOne);
    }
}
