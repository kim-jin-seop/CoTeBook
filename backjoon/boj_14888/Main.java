package boj_14888;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0 ;i< a.length; i++){
            a[i] = sc.nextInt();
        }
        int plusNum = sc.nextInt();
        int minusNum = sc.nextInt();
        int mulNum = sc.nextInt();
        int divNum = sc.nextInt();

        int[] cal = new int[n-1];
        ArrayList<int[]> cals = new ArrayList<>();
        orderCal(cals,cal,plusNum,minusNum,mulNum,divNum,0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int result = 0;
        for(int i = 0; i < cals.size(); i++){
            int x = a[0];
            int y;
            int[] c = cals.get(i);
            for(int j = 1; j < a.length; j++){
                int oper = c[j-1];
                y = a[j];
                if(oper == 1)
                    result = x+y;
                else if(oper == 2)
                    result = x-y;
                else if(oper == 3)
                    result = x*y;
                else{
                    result = x/y;
                }
                x = result;
            }
            if(max < result){
                max = result;
            }
            if(min > result){
                min =result;
            }
            result = 0;
        }
        System.out.println(max);
        System.out.println(min);
    }

    public static void orderCal(ArrayList<int[]> cals, int[] cal, int plusNum, int minusNum, int mulNum, int divNum, int idx){

        if(idx == cal.length){
            int[] result = new int[cal.length];
            for(int i = 0; i < cal.length; i++){
                result[i] = cal[i];
            }
            cals.add(result);
            return;
        }

        if(plusNum != 0){
            cal[idx] = 1;
            orderCal(cals,cal,plusNum-1,minusNum,mulNum,divNum,idx+1);
        }
        if(minusNum != 0){
            cal[idx] = 2;
            orderCal(cals,cal,plusNum,minusNum-1,mulNum,divNum,idx+1);
        }
        if(mulNum != 0){
            cal[idx] = 3;
            orderCal(cals,cal,plusNum,minusNum,mulNum-1,divNum,idx+1);
        }
        if(divNum != 0){
            cal[idx] = 4;
            orderCal(cals,cal,plusNum,minusNum,mulNum,divNum-1,idx+1);
        }
    }
}
