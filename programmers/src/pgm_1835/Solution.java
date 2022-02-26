package pgm_1835;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int n, String[] data) {
        int answer = 0;

        char[] names = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        int[] permutation = {1,2,3,4,5,6,7,8};
        Map<Character,Integer> position = new HashMap<>();
        do {
            switchPosition(names, permutation, position);
            if(checkCondition(n, data, position))
                answer++;
        }while (nextPermutation(permutation,8));

        return answer;
    }

    private boolean checkCondition(int n, String[] data, Map<Character, Integer> position) {
        int i;
        for(i = 0; i < n; i++){
            Integer positionA = position.get(data[i].charAt(0));
            Integer positionB = position.get(data[i].charAt(2));
            int dis = Math.abs(positionA - positionB);
            if(data[i].charAt(3) == '=' && dis-1 != data[i].charAt(4)-'0'){
                break;
            }
            else if(data[i].charAt(3) == '<' && dis-1 > data[i].charAt(4)-'0'-1){
                break;
            }
            else if(data[i].charAt(3) == '>' && dis-1 < data[i].charAt(4)-'0'+1){
                break;
            }
        }
        if(i != n){
            return false;
        }
        return true;
    }

    private void switchPosition(char[] names, int[] permutation, Map<Character, Integer> position) {
        for(int i = 0; i < names.length; i++){
            position.put(names[i], permutation[i]);
        }
    }

    private boolean nextPermutation(int[] numbers, int n){
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
                int temp = numbers[i];
                numbers[i] = numbers[changeIndex];
                numbers[changeIndex] = temp;
                break;
            }
        }
        while(++changeIndex < --n){
            int temp = numbers[n];
            numbers[n] = numbers[changeIndex];
            numbers[changeIndex] = temp;
        }
        return true;
    }
}