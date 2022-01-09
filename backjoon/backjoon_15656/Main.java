package backjoon_15656;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] a;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        a = new int[m];
        int[] data = new int[n];
        for(int i = 0; i < n ; i++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        find(data,0, m);
        bw.flush();
    }

    static void find(int[] data, int index, int m) throws IOException {
        if(index == m){
            for(int i = 0; i< a.length; i++){
                bw.write(a[i]+" ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i < data.length; i++){
            a[index] = data[i];
            find(data,index+1,m);
            a[index] = 0;
        }
    }
}
