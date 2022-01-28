package pgm_12899;

import java.util.ArrayList;

class Solution {
    public String solution(int n) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0){
            list.add(n%3);
            n = n / 3;
        }
        

        for(int i = 0; i < list.size(); i++){
            answer = list.get(i) + answer;
        }
        return answer;
    }
}