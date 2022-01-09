package level1_problem_12943;

public class Solution {
    public int solution(long num) {
        int count = 0;

        if(num == 1)
            return count;

        while(count != 500){
            if(num == 1)
                break;
            if(num % 2 == 0)
                num = num / 2;
            else
                num = (3*num) + 1;

            count = count+1;
        }
        return count == 500 ? -1 : count;
    }
}