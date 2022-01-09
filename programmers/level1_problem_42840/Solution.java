package level1_problem_42840;

public class Solution {
    public int[] solution(int[] answers) {
        final int personNum = 3;

        int[] answer = {};
        int resultcount = 0;
        int[] num_first = {1,2,3,4,5};
        int[] num_second = {2,1,2,3,2,4,2,5};
        int[] num_third = {3,3,1,1,2,2,4,4,5,5};
        int[] correct = new int[personNum];
        boolean[] result_who = new boolean[correct.length];

        for(int i = 0; i < answers.length; i++){
            correct[0] += num_first[i%num_first.length] == answers[i] ? 1 : 0;
            correct[1] += num_second[i%num_second.length] == answers[i] ? 1 : 0;
            correct[2] += num_third[i%num_third.length] == answers[i] ? 1 : 0;
        }

        int max = personNum-1;
        for(int i = max-1; i >= 0; i --){
            if(correct[max] <= correct[i])
                max = i;
        }

        for(int i = max; i < personNum; i++){
            if(correct[max] == correct[i]){
                result_who[i] = true;
                resultcount++;
            }
        }

        answer = new int[resultcount];
        int index = 0;
        for(int i = max; i < personNum; i++){
            if(result_who[i]){
                answer[index++] = i+1;
            }
        }

        return answer;
    }
}