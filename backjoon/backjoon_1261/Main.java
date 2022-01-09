package backjoon_1261;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] miro = new int[n][m];
        for(int i =0; i < n; i++){
            String line = sc.next();
            for(int j = 0; j < m; j++){
                miro[i][j] = line.charAt(j)-'0';
            }
        }

        int[][] check = new int[n][m];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> nextQueue = new LinkedList<>();
        queue.add(0);
        queue.add(0);
        check[0][0] = 1;
        while (!queue.isEmpty()){
            bfs(queue,nextQueue,miro,check);

            if(queue.isEmpty()){
                queue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        System.out.println(check[n-1][m-1] - 1);
    }

    public static void bfs(Queue<Integer> queue, Queue<Integer> nextQueue, int[][] miro,int [][] check){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int x = queue.remove();
        int y = queue.remove();

        for(int i = 0; i < dx.length; i++){
            if(x+dx[i] >= 0 && x+dx[i] < miro.length && y+dy[i] >= 0 && y+dy[i] < miro[0].length && check[x+dx[i]][y+dy[i]] == 0){
                if(miro[x+dx[i]][y+dy[i]] == 0){
                    queue.add(x+dx[i]);
                    queue.add(y+dy[i]);
                    check[x+dx[i]][y+dy[i]] = check[x][y];
                }
                else{
                    nextQueue.add(x+dx[i]);
                    nextQueue.add(y+dy[i]);
                    check[x+dx[i]][y+dy[i]] = check[x][y]+1;
                }
            }
        }
    }
}
