package level1_problem_12921;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        boolean isPrime;

        for(int i = 2; i <= n; i ++){
            isPrime = true;
            for(int j = 2; j <= Math.sqrt(i); j ++){
                if(i%j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime)
                count++;
        }

        answer = count;
        return answer;
    }
}