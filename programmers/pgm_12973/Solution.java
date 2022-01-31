package pgm_12973;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.add(s.charAt(i)-'0');
                continue;
            }

            int front = stack.pop();
            int back = s.charAt(i) -'0';

            if(front == back)
                continue;
            stack.add(front);
            stack.add(back);
        }

        if (stack.isEmpty())
            return 1;
        return 0;
    }
}