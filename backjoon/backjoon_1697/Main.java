package backjoon_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] check = new int[100001];
        for(int i = 0; i < check.length; i++){
            check[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = 0;
        while (!queue.isEmpty())
            bfs(queue,check);
        System.out.println(check[k]);
    }

    public static void bfs(Queue<Integer> queue, int[] check){
        int x = queue.remove();

        if(x+1 < check.length && check[x+1] == -1){
            queue.add(x+1);
            check[x+1] = check[x] + 1;
        }
        if(x-1 >= 0 && check[x-1] == -1){
            queue.add(x-1);
            check[x-1] = check[x] + 1;
        }
        if(2*x <= check.length && check[2*x] == -1){
            queue.add(2*x);
            check[2*x] = check[x] + 1;
        }
    }
}