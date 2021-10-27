package backjoon_2529;

import java.util.Scanner;

public class Main {
    static String min = String.valueOf(Long.MAX_VALUE);
    static String max =  String.valueOf(0);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] sign = new char[n];
        for(int i = 0; i < n; i++){
            sign[i] = sc.next().charAt(0);
        }
        boolean[] c = new boolean[10];
        find(sign,0,c,"");
        System.out.println(max);
        System.out.println(min);
    }

    private static void find(char[] sign, int index, boolean[] c, String result){
        if(sign.length+1 == index){
            for(int i = 0; i < sign.length; i++){
                char s = sign[i];
                int front = result.charAt(i);
                int back = result.charAt(i+1);
                if(s == '<' && front > back) return;
                if(s == '>' && front < back) return;
            }
            long resultLong = Long.parseLong(result);
            long minValue = Long.parseLong(min);
            long maxValue = Long.parseLong(max);

            max = resultLong > maxValue ? result : max;
            min = resultLong < minValue ? result : min;
            return;
        }

        for(int i = 0; i < 10; i++){
            if(c[i])
                continue;
            c[i] = true;
            find(sign,index+1,c,result+i);
            c[i] = false;
        }
    }
}
