package backjoon_11724;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertexSize = sc.nextInt();
        int edgeSize = sc.nextInt();

        ArrayList<Integer>[] edgeList = new ArrayList[vertexSize+1];
        for(int i = 1; i <= vertexSize; i++)
            edgeList[i] = new ArrayList<Integer>();

        for(int i = 0; i < edgeSize; i++){
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();

            edgeList[firstVertex].add(secondVertex);
            edgeList[secondVertex].add(firstVertex);
        }

        boolean[] checked = new boolean[vertexSize+1];
        int count = 0;
        for(int i = 1; i <= vertexSize; i++){
            if(!checked[i]){
                dfs(i,checked,edgeList);
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int x, boolean[] checked, ArrayList<Integer>[] edgeList){
        checked[x] = true;
        ArrayList<Integer> vertexs = edgeList[x];
        for(int i = 0; i < vertexs.size(); i++){
            int ver =vertexs.get(i);
            if(!checked[ver])
                dfs(ver,checked,edgeList);
        }
    }
}
