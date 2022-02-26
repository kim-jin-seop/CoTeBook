package level1_problem_12917;


import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++)
            answer = list.get(i) + answer;
        return answer;
    }
}