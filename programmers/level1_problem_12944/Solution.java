package level1_problem_12944;

public class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        for(int element : arr){
            answer += element;
        }
        answer = answer / arr.length;
        return answer;
    }
}
