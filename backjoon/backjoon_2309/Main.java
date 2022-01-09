package backjoon_2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] length = new int[n];
        int sum = 0;
        for(int i = 0; i< n; i++){
            length[i] = sc.nextInt();
            sum += length[i];
        }
        Arrays.sort(length);

        int d = sum - 100;

        boolean find = false;
        boolean[] lie = new boolean[9];
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(length[i] + length[j] == d){
                    lie[j] = true;
                    lie[i] = true;
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }

        for(int i = 0; i < n; i++){
            if(!lie[i])
                System.out.println(length[i]);
        }
    }
}
