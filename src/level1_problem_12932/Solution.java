package level1_problem_12932;

import java.util.ArrayList;

public class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        while(n != 0L) {
            list.add((int) (n % 10));
            n = n / 10;
        }
        answer = list.stream().mapToInt(e->e).toArray();
        return answer;
    }
}