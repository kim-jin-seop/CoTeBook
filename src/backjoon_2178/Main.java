package backjoon_2178;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] miro = new int[n][m];

        for(int i = 0; i < n; i++){
            String line = sc.next();
            for(int j = 0; j < m; j++){
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] lengths = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                lengths[i][j] = Integer.MAX_VALUE;
        }

        dfs(0,0,miro,lengths,1);
        System.out.println(lengths[n-1][m-1]);
    }

    public static void dfs(int x, int y, int[][] miro, int[][] lengths, int depth){
        lengths[x][y] = depth;
        if(x+1 < miro.length && miro[x+1][y] == 1){
            if(lengths[x+1][y] > depth+1){
                dfs(x+1,y,miro,lengths,depth+1);
            }
        }
        if(y+1 < miro[x].length && miro[x][y+1] == 1){
            if(lengths[x][y+1] > depth+1){
                dfs(x,y+1,miro,lengths,depth+1);
            }
        }
        if(x-1 >= 0 && miro[x-1][y] == 1){
            if(lengths[x-1][y] > depth+1){
                dfs(x-1,y,miro,lengths,depth+1);
            }
        }
        if(y-1 >= 0 && miro[x][y-1] == 1){
            if(lengths[x][y-1] > depth+1){
                dfs(x,y-1,miro,lengths,depth+1);
            }
        }
    }
}
