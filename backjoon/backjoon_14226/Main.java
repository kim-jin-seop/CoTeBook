package backjoon_14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = new Scanner(System.in).nextInt();
        int[][] check = new int[1001][1001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(0);
        check[1][0] = 1;

        while (!queue.isEmpty()){
            bfs(queue,check);
        }

        int min = check[count][1];
        for(int i = 1; i < check.length;i++){
            min = min > check[count][i] ? check[count][i] : min;
        }
        System.out.println(min-1);
    }

    public static void bfs(Queue<Integer> queue,int[][] check){
        int emoticonCount = queue.remove();
        int clipCount = queue.remove();

        if(emoticonCount-1 > 0 && check[emoticonCount-1][clipCount] == 0){
            queue.add(emoticonCount-1);
            queue.add(clipCount);
            check[emoticonCount-1][clipCount] = check[emoticonCount][clipCount] + 1;
        }
        if(check[emoticonCount][emoticonCount] == 0){
            queue.add(emoticonCount);
            queue.add(emoticonCount);
            check[emoticonCount][emoticonCount] = check[emoticonCount][clipCount] +1;
        }
        if(emoticonCount + clipCount < check.length&&check[emoticonCount + clipCount][clipCount] == 0){
            queue.add(emoticonCount+clipCount);
            queue.add(clipCount);
            check[emoticonCount+clipCount][clipCount] = check[emoticonCount][clipCount] +1;
        }
    }
}
