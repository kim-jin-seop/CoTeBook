package backjoon_10819;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = new int[n];
        System.out.println(go(n,0,result,arr,new boolean[n]));
    }

    public static int go(int n, int idx, int[] value, int[] arr,boolean[] check){
        if(n == idx){
            int sum = 0;
            for(int i = 0; i<n-1; i++){
                sum += Math.abs(value[i] - value[i+1]);
            }
            return sum;
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(check[i]){
                continue;
            }
            value[idx] = arr[i];
            check[i] = true;
            int result = go(n, idx + 1, value, arr,check);
            max = max < result ? result : max;
            check[i] = false;
        }
        return max;
    }
}
