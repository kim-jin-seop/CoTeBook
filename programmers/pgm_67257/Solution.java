package pgm_67257;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public long solution(String expression) {
        char[] operations = {'+', '-', '*'};
        Deque<String> queue = new LinkedList<>();

        String number = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOperation(c)) {
                queue.add(number);
                number = "";
                queue.add(String.valueOf(c));
                continue;
            }
            number = number + c;
        }
        queue.add(number);

        long max = 0;
        int[][] priors = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
        for (int i = 0; i < priors.length; i++) {
            Deque<String> calQueue = queueCopy(queue);

            for (int j = 0; j < priors[i].length; j++) {
                Deque<String> newQueue = new LinkedList<>();
                while (!calQueue.isEmpty()){
                    if(calQueue.size() == 1 && newQueue.isEmpty())
                        break;
                    else if(calQueue.size() == 1){
                        newQueue.add(calQueue.remove());
                        break;
                    }


                    String front = calQueue.remove();
                    String operation = calQueue.remove();
                    String back = calQueue.remove();

                    if (operations[priors[i][j]] == operation.charAt(0)) {
                        calQueue.addFirst(calculation(Long.valueOf(front), Long.valueOf(back), operation.charAt(0)));
                    } else {
                        newQueue.add(front);
                        newQueue.add(operation);
                        if(calQueue.isEmpty())
                            newQueue.add(back);
                        else
                            calQueue.addFirst(back);
                    }
                }
                if(calQueue.size() != 1)
                    calQueue = newQueue;
            }
            long val = Math.abs(Long.valueOf(calQueue.remove()));
            max = max < val ? val : max;
        }
        return max;
    }

    public Deque<String> queueCopy(Deque<String> queue){
        ArrayList<String> list = new ArrayList<>();
        while (!queue.isEmpty()){
            list.add(queue.remove());
        }

        Deque<String> resultQueue = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            resultQueue.add(list.get(i));
            queue.add(list.get(i));
        }
        return resultQueue;
    }

    public String calculation(long a, long b, char operation) {
        if (operation == '+')
            return String.valueOf(a + b);
        else if (operation == '-')
            return String.valueOf(a - b);
        else
            return String.valueOf(a * b);
    }

    public boolean isOperation(char c) {
        return c == '+' || c == '*' || c == '-';
    }
}
