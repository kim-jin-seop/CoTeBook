package pgm_87946;

public class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] permutation = new int[dungeons.length];
        for(int i = 0; i < permutation.length; i++){
            permutation[i] = i;
        }
        int max = 0;
        do{
            int count = doDungeons(permutation, dungeons, k);
            max = max > count ? max : count;
        }while (nextPermutation(permutation));
        return max;
    }

    public int doDungeons(int[] permutation, int[][] dungeons, int p){
        int count = 0;
        for(int i = 0; i < permutation.length; i++){
            if(dungeons[permutation[i]][0] <= p){
                p -= dungeons[permutation[i]][1];
                count++;
            }
        }
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
}
