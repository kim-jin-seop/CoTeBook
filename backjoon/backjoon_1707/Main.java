package backjoon_1707;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testSize = sc.nextInt();

        for (int i = 0; i < testSize; i++) {
            int vertexCount = sc.nextInt();
            int edgeCount = sc.nextInt();

            boolean[] checked = new boolean[vertexCount + 1];
            boolean[] position = new boolean[vertexCount + 1];
            ArrayList<Integer>[] adLists = new ArrayList[vertexCount + 1];
            makeRelationEdge(sc, vertexCount, edgeCount, adLists);
            boolean result = true;
            for(int j = 1; j <= vertexCount && result; j++){
                if(!checked[j]){
                    result = dfs(j, adLists, checked, position);
                }
            }
            if (result)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }


    private static boolean dfs(int x, ArrayList<Integer>[] adLists, boolean[] checked, boolean[] position) {
        checked[x] = true;
        ArrayList<Integer> adList = adLists[x];

        for (int i = 0; i < adList.size(); i++) {
            int vertex = adList.get(i);
            if (!checked[vertex]) {
                if (position[x])
                    position[vertex] = false;
                else
                    position[vertex] = true;

                if (!dfs(vertex, adLists, checked,position))
                    return false;
            } else {
                if(position[vertex] == position[x])
                    return false;
            }

        }
        return true;
    }

    private static void makeRelationEdge(Scanner sc, int vertexCount, int edgeCount, ArrayList<Integer>[] adList) {
        for (int i = 1; i <= vertexCount; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            adList[first].add(second);
            adList[second].add(first);
        }
    }
}
