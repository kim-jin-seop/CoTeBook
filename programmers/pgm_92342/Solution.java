package pgm_92342;

public class Solution {

    public static void main(String[] args) {
        solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1});
        System.out.println("끝");
    }

    static int[] result = new int[11];
    static int maxPoint = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info) {
        int[] answer;
        shot(n, 0, info, new int[11]);
        if (maxPoint <= 0)
            answer = new int[]{-1};
        else
            answer = result;
        return answer;
    }

    public static void shot(int n, int start, int[] info, int[] shots) {
        if (n == 0) {
            int calPoint = calPoint(info, shots);
            System.out.print("calpoint == maxPoint : ");
            System.out.println(calPoint == maxPoint);
            System.out.println("calPoint = " + calPoint);
            System.out.println("maxPoint = " + maxPoint);
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

    public static int calPoint(int[] info, int[] shots) {
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