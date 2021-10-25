package backjoon_1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();

        boolean[] check = new boolean[c];
        String[] data = new String[c];

        for(int i = 0; i<c; i++){
            data[i] = sc.next();
        }

        Arrays.sort(data);
        solve(data,check,0,0,l);
    }

    public static void solve(String[] data,boolean[] check, int cnt, int start,int l){
        if(cnt == l){
            String result = "";
            int n = 0,m = 0;
            for(int i = 0; i < data.length; i++){
                if(check[i]){
                    result += data[i];
                    if(data[i].matches("[aeiou]"))
                        n++;
                    else
                        m++;
                }
            }
            if(n >0 && m >1)
                System.out.println(result);
            return;
        }

        for(int i = start; i <data.length; i++){
            check[i] = true;
            solve(data,check,cnt+1,i+1,l);
            check[i] = false;
        }
    }
}
