package twonumberadd;

import java.util.HashSet;
import java.util.Iterator;

public class Solution {

    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                set.add(numbers[j]+numbers[i]);
            }
        }

        set.stream().sorted();
        answer = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        for(int i = 0 ;it.hasNext(); i++)
            answer[i] = it.next();

        return answer;
    }
}
