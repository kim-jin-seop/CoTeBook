package backjoon_15650;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        find(n,m,1,"");
    }

    public static void find(int n, int m, int start, String s){
        if(m ==0){
            System.out.println(s);
        }
        else{
            for(int i = start; i <= n; i ++){
                String input = s + i + " ";
                find(n,m-1,i+1,input);
            }
        }
    }
}
