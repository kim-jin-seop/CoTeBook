package level1_problem_12901;

public class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = {0,31,60,91,121,152,182,213,244,274,305,335};
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        answer = day[(month[a-1]+b-1)%7];
        return answer;
    }
}