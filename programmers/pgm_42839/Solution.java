package pgm_42839;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String numbers) {
        int[] permutation = new int[numbers.length()];
        for(int i = 0; i < permutation.length; i++)
            permutation[i] = i;

        int count = 0;
        Set<Integer> set = new HashSet<>();
        do{
            int[] inputNumbers = new int[numbers.length()];
            for(int i = 0; i < permutation.length; i++){
                inputNumbers[i] = numbers.charAt(permutation[i]) - '0';
            }
            boolean[] checked = new boolean[numbers.length()];
            count += recursiveCheckNumber(inputNumbers,checked,0,set);
        }while (nextPermutation(permutation));

        return count;
    }

    private boolean nextPermutation(int[] numbers){
        int prevIndex;
        int n = numbers.length;
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

    private void swap(int[] numbers, int a, int b){
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public int recursiveCheckNumber(int[] numbers, boolean[] checked, int checkedNumber,Set<Integer> set) {
        if(checkedNumber == numbers.length){
            String number = "";
            for(int i = 0; i < numbers.length; i++){
                if(checked[i])
                    number = number + numbers[i];
            }

            if(number.equals(""))
                return 0;

            if(set.contains(Integer.parseInt(number)))
                return 0;
            set.add(Integer.parseInt(number));

            if(isPrime(Integer.parseInt(number)))
                return 1;
            else
                return 0;
        }

        checked[checkedNumber] = true;
        int a = recursiveCheckNumber(numbers,checked,checkedNumber+1,set);
        checked[checkedNumber] = false;
        int b = recursiveCheckNumber(numbers,checked,checkedNumber+1,set);
        return a + b;
    }

    public boolean isPrime(int number){
        if(number == 1 || number == 0)
            return false;
        for(int i = 2; i*i <= number; i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
}