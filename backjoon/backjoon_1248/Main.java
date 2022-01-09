package backjoon_1248;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] list = new char[n][n];
        int[] result = new int[n];

        String s = sc.next();
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                list[i][j] = s.charAt(index++);
            }
        }
        find(list,0,result);
    }

    private static boolean check(char[][] list, int index, int[] arr){
        int sum = 0;
        for(int i = index; i >= 0; i--){
            sum += arr[i];
            char c = sum > 0 ? '+' : sum == 0 ? '0' : '-';
            if(list[i][index] != c)
                return false;
        }
        return true;
    }

    public static boolean find(char[][] list, int index, int[] array){
        if(index == array.length){
            for(int i = 0; i< array.length; i++){
                System.out.print(array[i] + " ");
            }
            return true;
        }
        if(list[index][index] == '+'){
            for(int i = 0; i <= 10; i++){
                array[index] = i;
                if(check(list,index,array)&&find(list, index+1, array))
                    return true;
            }
        }
        else if(list[index][index] == '-'){
            for(int i = -10; i < 0; i++){
                array[index] = i;
                if(check(list,index,array)&&find(list, index+1, array))
                    return true;
            }
        }
        else {
            array[index] = 0;
            return (find(list, index + 1, array));
        }
        return false;
    }
}