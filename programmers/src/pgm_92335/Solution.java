package pgm_92335;

public class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        String value = makeJinSu(n, k,"");
        String[] values = value.split("0+");

        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("1"))
                continue;
            if (isPrime(Long.parseLong(values[i])))
                answer++;
        }
        return answer;
    }

    private boolean isPrime(long val) {
        if(val == 1L)
            return false;

        for (long j = 2; j * j <= val; j++) {
            if (val % j == 0) {
                return false;
            }
        }
        return true;
    }

    public String makeJinSu(int n, int k,String result) {
        if(n < k)
            return n%k+result;
        return makeJinSu(n/k,k,n%k + result);
    }
}