package backjoon_2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] checked = new boolean[n][n];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                if(!checked[i][j]){
                    int dfs = dfs(i,j,checked,map);
                    if(dfs != 0)
                        result.add(dfs);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    public static int dfs(int x, int y, boolean[][] checked, int[][] map) {
        checked[x][y] = true;

        int count = map[x][y];
        if (count == 1) {
            if (x - 1 >= 0 && !checked[x - 1][y]) {
                count += dfs(x - 1, y, checked, map);
            }
            if (y - 1 >= 0 && !checked[x][y - 1]) {
                count += dfs(x,y-1,checked,map);
            }
            if (x + 1 < checked.length && !checked[x + 1][y]) {
                count += dfs(x+1,y,checked,map);
            }
            if (y + 1 < checked.length && !checked[x][y + 1]) {
                count += dfs(x,y+1,checked,map);
            }
        }
        return count;
    }
}
