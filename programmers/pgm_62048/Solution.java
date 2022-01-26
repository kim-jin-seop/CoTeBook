package pgm_62048;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = gcd(w, h);
        long remove = ((h / gcd) + (w / gcd) - 1) * gcd;
        answer = ((long)w * (long)h) - remove;
        return answer;
    }

    public int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}