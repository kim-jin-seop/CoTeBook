package level1_kakao_42889;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageNow = new int[N + 2];
        int[] stagePass = new int[N + 2];
        double[] percent = new double[N + 1];

        for (int remainStage : stages) {
            stageNow[remainStage] += 1;
        }

        int sum = 0;
        for (int i = stagePass.length - 1; i > 0; i--) {
            sum += stageNow[i];
            stagePass[i] = sum;
        }

        for (int i = 1; i < percent.length; i++) {
            if(stagePass[i] == 0)
                continue;
            percent[i] = stageNow[i] / (stagePass[i] * 1.0);
        }

        int max = 1;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 1; j < percent.length; j++)
                if (percent[j] > percent[max])
                    max = j;
            answer[i] = max;
            percent[max] = -1;
        }

        return answer;
    }
}
