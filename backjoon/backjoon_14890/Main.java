package backjoon_14890;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int roadCount = 0;

        //가로 확인
        for(int i = 0; i < n; i++){
            int[] road = map[i];
            if(isRoad(road,l)) {
                roadCount += 1;
            }
        }

        //세로 확인
        for(int i = 0; i < n; i++){
            int[] road = new int[n];
            for(int j = 0; j < n; j++){
                road[j] = map[j][i];
            }
            if(isRoad(road,l)) {
                roadCount += 1;
            }
        }

        System.out.println(roadCount);
    }

    public static boolean isRoad(int[] road, int l){
        int equalCount = 1;
        int prev = road[0];
        int i = 1;
        for(;i< road.length; i++){
            if(road[i] == prev)
                equalCount++;
            else if(road[i] > prev && road[i]-1 == prev){
                if(equalCount < l)
                    break;
                prev = road[i];
                equalCount = 1;
            }
            else if(road[i] < prev && road[i]+1 == prev && i+l-1 < road.length){
                int j = 0;
                for(; j < l; j++){
                    if(road[i+j] != road[i])
                        break;
                }
                if(j != l)
                    break;
                i = i+l-1;
                prev = road[i];
                equalCount = 0;
            }
            else{
                break;
            }
        }
        return i == road.length;
    }
}
