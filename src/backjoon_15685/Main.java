package backjoon_15685;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        boolean[][] location = new boolean[101][101];
        int curveSize = sc.nextInt();

        while (curveSize-- != 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            makeCurve(location, x, y, d, g);
        }

        int count = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
            }
        }

        System.out.println(count);
    }

    public static void makeCurve(boolean[][] location, int x, int y, int d, int g) {
        ArrayList<int[]> list = new ArrayList<>();
        addCurvePoint(location, x, y, list);
        System.out.println(x+" " + y);
        // 0세대
        if (d == 0)
            x++;
        else if (d == 1)
            y--;
        else if (d == 2)
            x--;
        else
            y++;
        addCurvePoint(location, x, y, list);
        System.out.println(x+" " + y);
        //1세대 이상
        for (int i = 0; i < g; i++) {
            int[] point = new int[2];
            int size = list.size()-1;
            boolean first = true;
            for(int idx = 0; idx < size; idx++){
                int[] loc = list.get(idx);
                point = move(x, y, loc);
                addCurvePoint(location,point[0],point[1],list);
                if(first){
                    x = point[0];
                    y = point[1];
                    first = false;
                }
                System.out.println(point[0] + " " + point[1]);
            }
            first = true;
        }
    }

    private static int[] move(int x, int y , int[] loc){
        int locX = loc[0] - x;
        int locY = loc[1] - y;
        int[] mul = locX <= 0 && locY >= 0 ? new int[]{-1,1} : locX >=0 && locY >=0 ? new int[]{1,-1}
                : locX >= 0 && locY <= 0 ? new int[]{-1,1} : new int[]{1,-1};
        return new int[]{locY*mul[0]+x,locX*mul[1]+y};
    }

    private static void addCurvePoint(boolean[][] location, int x, int y, ArrayList<int[]> list) {
        if (x >= 0 && y >= 0 && x <= 100 && y <= 100) {
            location[x][y] = true;
        }
        list.add(new int[]{x, y});
    }
}
