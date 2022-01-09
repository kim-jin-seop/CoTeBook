package boj_14225;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] result = new boolean[2000000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        boolean[] checked = new boolean[n];
        int[] s = new int[n];


        for (int i = 0; i < s.length; i++) {
            s[i] = sc.nextInt();
        }

        for(int i = 1; i <= s.length; i++){
            makePartSequence(arr,s,checked,i,0);
        }

        for(int i = 1; i < result.length; i++){
            if(!result[i]){
                System.out.println(i);
                break;
            }
        }

//        for(int i = 1; i < Integer.MAX_VALUE; i++){
//            int idx;
//            for(idx = 0; idx < arr.size(); idx++){
//                if(arr.get(idx) == i)
//                    break;
//            }
//            if(idx == arr.size()) {
//                System.out.println(i);
//                break;
//            }
//        }


    }

    public static void makePartSequence(ArrayList<Integer> arr, int[] s, boolean[] checked, int count,int start) {
        if(count == 0) {
            saveSum(arr,s,checked);
            return;
        }
        for(int i = start; i < checked.length; i++){
            if(checked[i])
                continue;
            checked[i] = true;
            makePartSequence(arr,s,checked,count-1,i);
            checked[i] = false;
        }
    }

    public static void saveSum(ArrayList<Integer> arr, int[] s, boolean[] checked) {
        int sum = 0;
        for (int i = 0; i < checked.length; i++) {
            if (checked[i])
                sum += s[i];
        }
        if(sum < result.length)
            result[sum] = true;
        arr.add(sum);
    }
}
