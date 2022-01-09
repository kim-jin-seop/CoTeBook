package backjoon_13913;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] check = new int[100001];
        int[] prev = new int[100001];
        for(int i = 0; i < check.length; i++){
            check[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = 0;
        prev[n] = n;
        while (!queue.isEmpty()){
            bfs(queue,check,prev);
        }

        System.out.println(check[k]);
        ArrayList<Integer> howToMove = new ArrayList<>();
        if(n != k)
            howToMove.add(k);
        while (prev[k] != n){
            howToMove.add(prev[k]);
            k = prev[k];
        }
        howToMove.add(n);

        for(int i = howToMove.size()-1; i >= 0; i--)
            bw.write(howToMove.get(i)+" ");
        bw.flush();
    }

    public static void bfs(Queue<Integer> queue, int[] check, int[] prev){
        int x = queue.remove();
        if(x+1 < check.length && check[x+1] == -1){
            queue.add(x+1);
            check[x+1] = check[x] + 1;
            prev[x+1] = x;
        }
        if(x-1 >= 0 && check[x-1] == -1){
            queue.add(x-1);
            check[x-1] = check[x] + 1;
            prev[x-1] = x;
        }
        if(2*x < check.length && check[x*2] == -1){
            queue.add(x*2);
            check[x*2] = check[x] + 1;
            prev[x*2] = x;
        }
    }
}
