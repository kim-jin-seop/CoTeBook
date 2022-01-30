package pgm_43165;

public class Solution {
    public int solution(int[] numbers, int target) {
        boolean[] signs = new boolean[numbers.length];
        int answer = recursive(numbers,signs,0,target);
        return answer;
    }

    public int recursive(int[] numbers,boolean[] signs, int check,int target) {
        if(check == numbers.length){
            int result = 0;
            for(int i = 0; i < numbers.length; i++){
                int sign = signs[i] ? 1 : -1;
                result += numbers[i] * sign;
            }
            if(result == target)
                return 1;
            else
                return 0;
        }
        signs[check] = false;
        int value1 = recursive(numbers,signs,check+1,target);
        signs[check] = true;
        int value2 = recursive(numbers,signs,check+1,target);
        return value1 + value2;
    }
}