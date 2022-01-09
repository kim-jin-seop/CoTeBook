package backjoon_15655;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] a;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        a = new int[n];
        int[] data = new int[n];
        for(int i = 0; i < n ; i++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        find(data,0,m,0);
        bw.flush();
    }

    public static void find(int[] data, int start, int m, int cnt) throws IOException {
        if(m == cnt){
            for(int i = 0; i < m; i++){
                bw.write(a[i] + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = start; i < data.length; i++){
            a[cnt] = data[i];
            find(data,i+1,m,cnt+1);
            a[cnt] = 0;
        }
    }
}
