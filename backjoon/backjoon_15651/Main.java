package backjoon_15651;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        find(n,m,"");
        bw.flush();
    }

    public static void find(int n, int m, String s) throws IOException {
        if(m == 0){
            bw.write(s);
            bw.newLine();
        }
        else{
            for(int i = 1; i <= n; i++){
                find(n,m-1,s + i + " ");
            }
        }
    }
}
