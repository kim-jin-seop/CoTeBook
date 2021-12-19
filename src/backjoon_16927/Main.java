package backjoon_16927;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int movementCount = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        ArrayList<ArrayList<Integer>> groups = grouping(arr);
        movement(movementCount, arr, groups);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void movement(int movementCount, int[][] arr, ArrayList<ArrayList<Integer>> groups) {
        int n = arr.length;
        int m = arr[0].length;
        for (int groupNum = 0; groupNum < groups.size(); groupNum++) {
            ArrayList<Integer> group = groups.get(groupNum);
            int index = movementCount % group.size();

            for (int j = groupNum; j< m -groupNum; j++, index = (index+1) % group.size()) {
                arr[groupNum][j] = group.get(index);
            }
            for (int i = groupNum+1; i< n -groupNum-1; i++, index = (index+1) % group.size()) {
                arr[i][m -groupNum-1] = group.get(index);
            }
            for (int j = m -groupNum-1; j>groupNum; j--, index = (index+1) % group.size()) {
                arr[n -groupNum-1][j] = group.get(index);
            }
            for (int i = n -groupNum-1; i>groupNum; i--, index = (index+1) % group.size()) {
                arr[i][groupNum] = group.get(index);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> grouping(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int groupSize = Math.min(n, m) / 2;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int groupNum = 0; groupNum < groupSize; groupNum++) {
            ArrayList<Integer> group = new ArrayList<>();
            for (int j = groupNum; j < m - groupNum; j++) {
                group.add(arr[groupNum][j]);
            }
            for (int i = groupNum + 1; i < n - groupNum - 1; i++) {
                group.add(arr[i][m - groupNum - 1]);
            }
            for (int j = m - groupNum - 1; j > groupNum; j--) {
                group.add(arr[n - groupNum - 1][j]);
            }
            for (int i = n - groupNum - 1; i > groupNum; i--) {
                group.add(arr[i][groupNum]);
            }
            groups.add(group);
        }
        return groups;
    }
}
