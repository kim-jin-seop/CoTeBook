package level1_problem_12982;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int requirement : d){
            if(budget < requirement)
                break;
            budget = budget-requirement;
            answer++;
        }
        return answer;
    }
}