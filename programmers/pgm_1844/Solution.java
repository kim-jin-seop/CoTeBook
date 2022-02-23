package pgm_1844;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[][] maps) {
        boolean[][] checked = new boolean[maps.length][maps[0].length];
        int[][] shortestLoad = new int[maps.length][maps[0].length];
        for(int i = 0; i < shortestLoad.length; i++){
            for (int j = 0; j < shortestLoad[i].length; j++)
                shortestLoad[i][j] = -1;
        }
        Queue<int[]> queue = new LinkedList<>();

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        queue.add(new int[]{0,0});
        checked[0][0] = true;
        shortestLoad[0][0] = 1;

        while (!queue.isEmpty()){
            int[] position = queue.remove();
            for(int i = 0; i < 4; i ++){
                int x = position[0] + dx[i];
                int y = position[1] + dy[i];
                if(isOk(x,maps.length) && isOk(y,maps[0].length) && !checked[x][y] && maps[x][y] != 0){
                    queue.add(new int[]{x,y});
                    checked[x][y] = true;
                    shortestLoad[x][y] = shortestLoad[position[0]][position[1]] + 1;
                }
            }
        }

        return shortestLoad[maps.length-1][maps[0].length-1];
    }

    private boolean isOk(int position, int maxLength){
        return  position >= 0 && position < maxLength;
    }
}