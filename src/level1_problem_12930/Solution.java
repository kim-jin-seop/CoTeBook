package level1_problem_12930;

public class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        String upper = s.toUpperCase();
        String lower = s.toLowerCase();

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == ' '){
                index = 0;
                answer = answer += " ";
                continue;
            }
            answer = answer + (index % 2 ==0 ? upper.charAt(i) : lower.charAt(i));
            index ++;
        }
        return answer;
    }
}