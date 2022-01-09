package level1_problem_68644;

import java.util.HashSet;
public class Solution {

    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                set.add(numbers[j]+numbers[i]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
