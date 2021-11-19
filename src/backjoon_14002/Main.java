package backjoon_14002;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Dp[] list = new Dp[n];
        for(int i = 0; i<n; i++){
            list[i] = new Dp(sc.nextInt());
        }

        for(int i = 0; i < n; i++){
            int numIndex = i;
            for(int j = i; j >= 0; j--){
                if(list[i].num > list[j].num)
                    if(list[numIndex].length <= list[j].length)
                        numIndex = j;
            }
            if(numIndex != i) {
                list[i].addList(list[numIndex].list);
                list[i].length += list[numIndex].length;
            }
        }

        int max = 0;
        for(int i = 0; i < list.length;i++){
            max = list[i].length > list[max].length ? i : max;
        }

        System.out.println(list[max].length);
        ArrayList<Integer> result_list = list[max].list;

        for(int i = result_list.size()-1; i>= 0; i--){
            System.out.print(result_list.get(i) + " ");
        }
    }

    public static class Dp{
        private ArrayList<Integer> list;
        private int num;
        private int length;

        public Dp(int num){
            this.num = num;
            list = new ArrayList<>();
            list.add(num);
            length = 1;
        }

        public void addList(ArrayList<Integer> list) {
            for (int i = 0; i < list.size(); i++)
                this.list.add(list.get(i));
        }
    }
}
