package backjoon_15654;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] data;
    static boolean[] c;
    static int[] a;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void find(int index, int m) throws IOException {
        if(index == m){
            for(int i = 0; i< a.length; i++){
                bw.write(a[i] +" ");
            }
            bw.newLine();
            return;
        }
        else{
            for(int i = 0; i < data.length; i++){
                if(c[i]) continue;
                c[i] = true;
                a[index] = data[i];
                find(index+1,m);
                c[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        data= new int[n];
        c = new boolean[n];
        a = new int[m];

        for(int i = 0; i < n; i++)
            data[i] = sc.nextInt();
        Arrays.sort(data);

        find(0,m);
        bw.flush();
    }
}