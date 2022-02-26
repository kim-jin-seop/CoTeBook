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

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) == 0) {
                list.remove(i);
                list.add(i,4);
                int carry = list.remove(i + 1) - 1 ;
                list.add(i+1,carry);
            }
            if(list.get(i) < 0){
                int removeI = list.remove(i);
                list.add(i,3+removeI);
                int carry = list.remove(i + 1) - 1 ;
                list.add(i+1,carry);
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != 0)
                answer = list.get(i) + answer;
        }
        return answer;
    }
}