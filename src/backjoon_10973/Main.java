package backjoon_10973;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i =0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        if(prev_permutation(numbers,n))
            for(int num : numbers){
                System.out.print(num+" ");
            }

    }

    public static boolean prev_permutation(int[] numbers, int n){
        int prev;
        int next = n-1;
        int changeIndex = -1;
        for(int i = n-2;i >=0; i--){
            prev = next;
            next = i;
            if(numbers[next] > numbers[prev]){
                changeIndex = next;
                break;
            }
        }

        if(changeIndex == -1){
            System.out.println(-1);
            return false;
        }

        for(int i = n-1; i > changeIndex; i--){
            if(numbers[i] < numbers[changeIndex]){
                int temp = numbers[i];
                numbers[i] = numbers[changeIndex];
                numbers[changeIndex] = temp;
                break;
            }
        }

        while(changeIndex+1 < n){
            changeIndex++;
            n--;
            int temp = numbers[n];
            numbers[n] = numbers[changeIndex];
            numbers[changeIndex] = temp;
        }
        return true;
    }
}
