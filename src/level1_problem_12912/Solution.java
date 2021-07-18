package level1_problem_12912;

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        boolean a_IsBig = Math.abs(a) > Math.abs(b) ? true : false;
        boolean a_IsPlus = a >= 0 ? true : false;
        boolean b_IsPlus = b >= 0 ? true : false;

        long a_Sum = Math.abs(a) * Math.abs(a + 1) / 2;
        long b_Sum = Math.abs(b) * Math.abs(b + 1) / 2;

        if(a_IsBig) {
            answer = a_Sum - b_Sum;
            if(!a_IsPlus)
                answer = answer*(-1);
        }
        else {
            answer = b_Sum - a_Sum;
            if(!b_IsPlus)
                answer = answer*(-1);
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

