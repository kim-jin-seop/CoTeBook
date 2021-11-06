package backjoon_10971;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] w = new int[n][n];
        int[] list = new int[n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i <n; i++){
            list[i] = i;
        }

        int min = Integer.MAX_VALUE;
        do{
            int sum = 0;
            int i = 0;
            for(; i < n; i++){
                if(w[list[i%n]][list[(i+1)%n]] == 0)
                    break;
                sum += w[list[i%n]][list[(i+1)%n]];
            }
            if(i == n){
                min = min > sum ? sum : min;
            }
        }while(nextPermutation(list));
        System.out.println(min);
    }

    public static boolean nextPermutation(int[] list) {
        int n = list.length;
        int prevIndex;
        int nextIndex = n-1;
        for(int i = n-2; i >= 0; i--){
            prevIndex = nextIndex;
            nextIndex = i;
            if(list[nextIndex] < list[prevIndex])
                break;
        }
        int changeIndex = -1;
        for(int i = nextIndex; i < n; i++){
            if(list[nextIndex] < list[i])
                changeIndex = i;
        }
        if(changeIndex == -1)
            return false;

        swap(list,changeIndex,nextIndex);
        while(nextIndex < n){
            nextIndex++;
            n--;
            swap(list,nextIndex,n);
        }
        return true;
    }

    public static void swap(int[] list, int a, int b){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
