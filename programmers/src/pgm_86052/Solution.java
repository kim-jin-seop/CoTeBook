package pgm_86052;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public Integer[] solution(String[] grid){
        char[][] g = new char[grid.length][grid[0].length()];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                g[i][j] = grid[i].charAt(j);
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<ArrayList<Light>> cycles = new ArrayList<>();

        for(int x = 0; x < g.length; x++){
            for(int y = 0; y < g[x].length; y++){
                for(int i = 0; i < 4; i++){
                    int result = checkCycle(g,new Light(0, 0, i), new Light(0, 0, i),cycles);
                    if(result != -1)
                        resultList.add(result);
                }
            }
        }

        return resultList.toArray(new Integer[0]);
    }

    public int checkCycle(char[][] grid ,Light first, Light light, ArrayList<ArrayList<Light>> cycles){
        Set<Light> set = new HashSet<>();
        int maxX = grid.length;
        int maxY = grid[0].length;
        ArrayList<Light> cycle = new ArrayList<>();

        while (!set.contains(light)){
            Light input = new Light(light.x, light.y, light.direct);
            set.add(input);
            cycle.add(input);
            int x = light.x;
            int y = light.y;
            if(grid[x][y] == 'S')
                light.moveStraight(maxX,maxY);
            else if(grid[x][y] == 'L')
                light.moveLeft(maxX, maxY);
            else if(grid[x][y] == 'R')
                light.moveRight(maxX,maxY);
        }

        if(!light.equals(first))
            return -1;

        boolean hasCycle = false;
        for(int i = 0; i < cycles.size() && !hasCycle; i++){
            if(cycles.get(i).size() == cycle.size()){
                int j = 0;
                for(j = 0; j < cycle.size(); j++){
                    if(cycle.get(0).equals(cycles.get(i).get(j)))
                        break;
                }

                int k = 0;
                for(k = 0; k < cycle.size(); k++){
                    if(!cycle.get(k).equals(cycles.get(i).get((j+k)%cycle.size()))){
                        break;
                    }
                }
                if(k == cycle.size())
                    hasCycle = true;
            }
        }

        if(!hasCycle){
            cycles.add(cycle);
        }
        else
            return -1;

        return cycle.size();
    }


    public class Light{
        int x;
        int y;
        int direct; // 0 : 북, 1 : 동, 2 : 남, 3 : 서

        public Light(int x, int y, int direct){
            this.x = x;
            this.y = y;
            this.direct = direct;
        }

        public void moveStraight(int maxX, int maxY){
            move(maxX,maxY);
        }

        public void moveLeft(int maxX, int maxY){
            direct = (direct + 3) % 4;
            move(maxX,maxY);
        }

        public void moveRight(int maxX, int maxY){
            direct = (direct + 1) % 4;
            move(maxX,maxY);
        }

        private void move(int maxX, int maxY){
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};

            this.x = (x + dx[direct] + maxX) % maxX;
            this.y = (y + dy[direct] + maxY) % maxY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Light light = (Light) o;
            return x == light.x && y == light.y && direct == light.direct;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direct);
        }
    }
}