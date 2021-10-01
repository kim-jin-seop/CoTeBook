package level2_problem_43165;

import java.util.Stack;

public class Solution {
    public int solution(int[] numbers, int target) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        //경우가 한개
        int num = 0;
        for(int i = 0; i < numbers.length; i++){
            num += numbers[i];
        }
        if(num == target)
            return 1;

        for(int i = 0; i < numbers.length; i++){
            boolean[] visit = new boolean[numbers.length];
            visit[i] = true;
            count += DFS(numbers,visit,stack);
        }

        return count;
    }

    private int DFS(int[] numbers, boolean[] visit, Stack<Integer> stack) {
        int sum = 0;
        for(int i = 0; i< numbers.length; i++){
            if(visit[i])
                sum -= numbers[i];
        }
        return 0;
    }


}