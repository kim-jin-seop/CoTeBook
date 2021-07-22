package level1_problem_12910;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int data : arr){
            if(data % divisor == 0)
                list.add(data);
        }
        if(list.size() == 0)
            list.add(-1);
        answer = list.stream().sorted().mapToInt(i->i).toArray();
        return answer;
    }
}