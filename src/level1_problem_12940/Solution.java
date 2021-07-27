package level1_problem_12940;

public class Solution {
    public int[] solution(int n, int m) {
        int[] result = new int[2];
        result[0] = GCD(n,m);
        result[1] = m * (n / result[0]);

        return result;
    }

    public int GCD(int n, int m){
        if(m == 0)
            return n;
        return GCD(m,n%m);
    }
}