package level1_problem_12903;

public class Solution {
    public String solution(String s) {
        String answer = "";

        if(s.length()%2 != 0){
            answer = ""+s.charAt(s.length()/2);
        }
        else{
            answer = s.charAt(s.length()/2-1)+""+s.charAt(s.length()/2);
        }
        return answer;
    }
}