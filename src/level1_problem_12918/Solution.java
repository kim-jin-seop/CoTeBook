package level1_problem_12918;

public class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        answer = (s.length() == 4 || s.length() == 6) && (!s.matches(".*[^0-9].*"));
        return answer;
    }
}