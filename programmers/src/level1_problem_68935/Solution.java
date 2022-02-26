package level1_problem_68935;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String change = "";
        int degree = 1;

        while(n != 0){
            change = n%3 + change;
            n = n / 3;
        }

        for(int i = 0; i < change.length(); i++){
            answer += degree*(change.charAt(i)-'0');
            degree *= 3;
        }

        return answer;
    }
}
