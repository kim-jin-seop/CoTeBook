package level1_problem_12933;

import java.util.ArrayList;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(n != 0L){
            list.add((int) (n%10));
            n = n/10;
        }
        int[] result_array = list.stream().sorted().mapToInt(e->e).toArray();

        for(int i = result_array.length-1; i >= 0; i--){
            answer = result_array[i] + answer*10;
        }
        return answer;
    }
}