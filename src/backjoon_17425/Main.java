package backjoon_17425;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 1000000;
        long[] d = new long[N+1];
        for(int i = 1; i <= N; i++){
            d[i] = 1;
        }
        for(int i = 2; i <= N; i++){
            for(int j = 1; i*j <= N ; j++){
                d[i*j] += i;
            }
        }

        long[] s = new long[N+1];
        for(int i = 1; i <= N; i++ ){
            s[i] = s[i-1] + d[i];
        }

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(s[n] +"\n");
        }
        bw.flush();
    }
}
