package backjoon_16194;

import java.util.Scanner;

public class Main {
    static int[] result = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n+1];
        for(int i = 1; i < n+1; i++){
            p[i] = sc.nextInt();
        }
        System.out.println(recursion(p,n));
    }

    public static int recursion(int[] p, int n){
        if(result[n] != 0)
            return result[n];

        int min = p[n];
        for(int i = 1; i < n; i++){
            int value = recursion(p,n-i) + p[i];
            min = Math.min(min, value);
        }
        return result[n] = min;
    }
}
