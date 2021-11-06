package backjoon_6603;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k;
        while ((k=sc.nextInt()) !=0) {
            int[] s = new int[k];
            for(int i = 0; i < k; i++)
                s[i] = sc.nextInt();
            find(s,new int[6],0,0,6);
            System.out.println();
        }
    }

    public static void find(int[] s, int[] num, int start, int idx, int n){
        if(n == idx){
            for(int i = 0 ;i < n; i++){
                System.out.print(num[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < s.length; i++){
            num[idx] = s[i];
            find(s,num,i+1,idx+1,n);
        }
    }
}