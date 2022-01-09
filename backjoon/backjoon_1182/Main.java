package backjoon_1182;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }


        int count = 0;
        for(int bit = 1;bit < (int)Math.pow(2,n); bit++) {
            if(isEqual(bit,num,s)){
                count ++;
            }
        }
        System.out.println(count);
    }

    public static boolean isEqual(int bit, int[] num, int s){
        int sum = 0;
        for(int idx = 0; bit > 0; idx++){
            if((bit & 1) == 1){
                sum += num[idx];
            }
            bit =  bit >> 1;
        }
        if(sum == s)
            return true;
        else
            return false;
    }
}
