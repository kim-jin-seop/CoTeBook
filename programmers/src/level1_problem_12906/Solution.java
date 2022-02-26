package level1_problem_12906;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int same = arr[0];
        list.add(same);
        for(int i = 1; i<arr.length; i++){
            if(same == arr[i])
                continue;
            same = arr[i];
            list.add(same);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}