package backjoon_6064;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i ++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;

            boolean find = false;
            for(int year = x; year <(n*m); year+= m)
                if(year%n == y){
                    find = true;
                    System.out.println(year+1);
                    break;
                }
            if(!find)
                System.out.println(-1);
        }
    }
}