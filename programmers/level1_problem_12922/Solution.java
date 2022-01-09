package level1_problem_12922;

public class Solution {
    public String solution(int n) {
        String answer = "";
        int count = n / 2;
        int remain = n % 2;

        for(int i = 0; i < count; i++)
            answer += "수박";

        if(remain == 1)
            answer += "수";

        return answer;
    }
}