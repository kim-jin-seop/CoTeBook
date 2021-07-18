package level1_problem_12912;

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long a_abs = Math.abs(a);
        long b_abs = Math.abs(b);
        boolean a_IsBig = a_abs > b_abs ? true : false;
        boolean a_IsPlus = a >= 0 ? true : false;
        boolean b_IsPlus = b >= 0 ? true : false;

        long a_Sum = a_abs * (a_abs+1) / 2;
        long b_Sum = b_abs * (b_abs+1) / 2;

        if(a_IsBig) {
            answer = a_Sum - b_Sum;
            if(!a_IsPlus)
                answer *= -1;
        }
        else {
            answer = b_Sum - a_Sum;
            if(!b_IsPlus)
                answer *= -1;
        }

        if((a_IsPlus && b_IsPlus)||(!a_IsPlus&&!b_IsPlus)){
            if(a_IsBig)
                answer += b;
            else
                answer += a;
        }
        return answer;
    }
}

