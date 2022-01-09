package backjoon_14501;

import java.util.Scanner;

public class Main {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];

        for(int i = 0; i < n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        findResult(n,t,p,0,0);
        System.out.println(max);
    }

    public static void findResult(int n, int[] t, int[] p,int day,int sum){
        if(day == n){
            if(sum > max)
                max = sum;
            return;
        }
        else if(day > n)
            return;
        for(int i = day; i < n;i++){
            sum += p[i];
            findResult(n,t,p,i+t[i],sum);
            sum -= p[i];
        }
        if(sum > max)
            max = sum;
    }
}
