package pgm_42746;

import java.util.*;

public class Solution {
    public String solution(int[] numbers) {

        List<Integer> numberList = new ArrayList<>();
        for(int number : numbers)
            numberList.add(number);

        Collections.sort(numberList,
                (o1, o2)-> {
                    String front = String.valueOf(o1);
                    String back = String.valueOf(o2);
                    return Integer.parseInt(front + back) < Integer.parseInt(back + front) ? 1 :
                            Integer.parseInt(front + back) == Integer.parseInt(back + front) ? 0 : -1;
                });

        String result = "";
        long sum = 0;
        for(int number : numberList){
            result = result + number;
            sum += number;
            sum %= Integer.MAX_VALUE;
        }
        if(sum == 0)
            result = "0";
        return result;
    }
}