package pgm_92342;

public class Solution {
    int[] result = new int[11];
    int maxPoint = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        int[] answer;
        shot(n, 0, info, new int[11]);
        if (maxPoint <= 0)
            answer = new int[]{-1};
        else
            answer = result;
        return answer;
    }

    public void shot(int n, int start, int[] info, int[] shots) {
        if (n == 0) {
            int calPoint = calPoint(info, shots);
            if (calPoint > maxPoint) {
                maxPoint = calPoint;
                for (int i = 0; i < result.length; i++) {
                    result[i] = shots[i];
                }
            }
            else if(calPoint == maxPoint){
                boolean change = false;
                for(int i = result.length-1; i >=0; i--) {
                    if (result[i] < shots[i]) {
                        change = true;
                        break;
                    }
                }
                if(change){
                    for (int i = 0; i < result.length; i++) {
                        result[i] = shots[i];
                    }
                }
            }
            return;
        }
        for (int i = start; i < info.length; i++) {
            if (n > info[i]) {
                shots[i] = info[i] + 1;
                shot(n - (info[i] + 1), i + 1, info, shots);
                shots[i] = 0;
            }
        }
        shots[10] += n;
        shot(0, 0, info, shots);
        shots[10] -= n;
    }

    public int calPoint(int[] info, int[] shots) {
        int point = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && shots[i] == 0)
                continue;
            if (info[i] < shots[i])
                point += (10 - i);
            else
                point -= (10 - i);
        }
        return point;
    }
}