package backjoon_10972;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 0 ;i <n; i++){
            numbers[i] = sc.nextInt();
        }

        int prev;
        int next = numbers[n-1];
        int changeIndex = -1;

        for(int i = n-2 ; i >= 0; i--){
            prev = next;
            next = numbers[i];

            if(next < prev){
                changeIndex = i;
                break;
            }
        }

        if(changeIndex == -1){
            System.out.println(-1);
            return;
        }
        int minIndex = changeIndex+1;
        for(int i = changeIndex+1; i < n; i++){
            if(numbers[i] > numbers[changeIndex] && numbers[i] < numbers[minIndex]){
                minIndex = i;
            }
        }

        int temp = numbers[minIndex];
        numbers[minIndex] = numbers[changeIndex];
        numbers[changeIndex] = temp;

        Arrays.sort(numbers,changeIndex+1,n);

        for(int num : numbers){
            System.out.print(num + " ");
        }
    }
}
