package backjoon_13549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] check = new int[100001];
        for (int i = 0; i < check.length; i++)
            check[i] = -1;

        Queue<Integer> queue = new LinkedList<>();
        if(n != 0) {
            int teleportation = n;
            while (teleportation < check.length) {
                queue.add(teleportation);
                check[teleportation] = 0;
                teleportation = teleportation * 2;
            }
        }
        else{
            queue.add(0);
            check[0] = 0;
        }

        while (!queue.isEmpty()) {
            bfs(queue,check);
        }

        System.out.println(check[k]);
    }

    public static void bfs(Queue<Integer> queue, int[] check) {
        int x = queue.remove();


        if(x != 0) {
            int teleportation = x;
            while (teleportation < check.length) {
                if (check[teleportation] == -1) {
                    queue.add(teleportation);
                    check[teleportation] = check[x];
                }
                teleportation = teleportation * 2;
            }
        }

        if(x-1 >= 0 && check[x-1] == -1){
            queue.add(x-1);
            check[x-1] = check[x] + 1;
        }

        if(x+1 < check.length && check[x+1] == -1){
            queue.add(x+1);
            check[x+1] = check[x] + 1;
        }
    }
}
