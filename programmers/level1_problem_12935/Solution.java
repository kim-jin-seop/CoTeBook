package level1_problem_12935;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        if(arr.length == 1)
            return new int[]{-1};

        int minIndex = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[minIndex] > arr[i])
                minIndex = i;
        }
        for(int i = 0; i < arr.length; i++){
            if(i == minIndex)
                continue;
            list.add(arr[i]);
        }
        return list.stream().mapToInt(e->e).toArray();
    }
}