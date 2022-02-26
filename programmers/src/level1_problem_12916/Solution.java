package level1_problem_12916;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int Pcount = 0,Scount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                Scount++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                Pcount++;
        }
        answer = Pcount == Scount;
        return answer;
    }
}