package backjoonj_10974;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 1; i <= n ; i++){
            numbers[i-1] = i;
        }
        print(n,numbers);

        while(next_permutation(numbers,n))
            print(n,numbers);
    }

    private static boolean next_permutation(int[] numbers, int n){
        int prevIndex;
        int nextIndex = n-1;
        int changeIndex = -1;

        for(int i = n-2; i >= 0; i--){
            prevIndex = nextIndex;
            nextIndex = i;

            if(numbers[nextIndex] < numbers[prevIndex]){
                changeIndex = nextIndex;
                break;
            }
        }

        if(changeIndex == -1)
            return false;

        for(int i = n-1; i > changeIndex; i--){
            if(numbers[i] > numbers[changeIndex]){
                swap(numbers, i, changeIndex);
                break;
            }
        }
        while(++changeIndex < --n){
            swap(numbers,changeIndex,n);
        }
        return true;
    }

    private static void swap(int[] numbers, int idx_1, int idx_2){
        int temp = numbers[idx_1];
        numbers[idx_1] = numbers[idx_2];
        numbers[idx_2] = temp;
    }

    private static void print(int n, int[] numbers) {
        for(int i = 0; i < n; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
