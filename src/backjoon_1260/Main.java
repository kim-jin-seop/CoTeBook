package backjoon_1260;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int startVertex = sc.nextInt();
        ArrayList<Integer>[] edgeList = new ArrayList[vertexCount+1];

        for(int i = 1; i <= vertexCount; i++){
            edgeList[i] = new ArrayList<>();
        }

        for(int i = 0; i < edgeCount; i++){
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();
            edgeList[firstVertex].add(secondVertex);
            edgeList[secondVertex].add(firstVertex);
        }

        for(int i = 1; i <= vertexCount; i++){
            Collections.sort(edgeList[i]);
        }

        boolean[] checked = new boolean[vertexCount+1];
        dfs(startVertex, checked, edgeList);
        System.out.println();

        checked = new boolean[vertexCount+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        checked[startVertex] = true;
        while(!queue.isEmpty())
            bfs(queue.remove(),checked,edgeList,queue);
    }

    static void bfs(int x, boolean[] checked, ArrayList<Integer>[] edgeList,Queue<Integer> queue){
        System.out.print(x+" ");
        ArrayList<Integer> vertexs = edgeList[x];
        for(int i = 0; i < vertexs.size(); i++){
            int ver = vertexs.get(i);
            if(!checked[ver]){
                checked[ver] = true;
                queue.add(ver);
            }
        }

    }

    static void dfs(int x, boolean[] checked, ArrayList<Integer>[] edgeList){
        checked[x] = true;
        System.out.print(x +" ");
        ArrayList<Integer> vertexs = edgeList[x];

        for(int i = 0; i < vertexs.size(); i++){
            int ver = vertexs.get(i);
            if(!checked[ver])
                dfs(ver,checked,edgeList);
        }
    }
}
