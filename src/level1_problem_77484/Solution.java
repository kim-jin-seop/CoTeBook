package level1_problem_77484;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zeroCount = 0;
        int lottoPointer = 0, winPointer = 0;
        int equalCount = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0)
                zeroCount += 1;
            else
                break;
        }

        while(lottoPointer != lottos.length && winPointer != win_nums.length){
            if(lottos[lottoPointer] == win_nums[winPointer]){
                equalCount++;
                lottoPointer += 1;
                winPointer += 1;
            }else if(lottos[lottoPointer] > win_nums[winPointer]){
                winPointer += 1;
            }
            else{
                lottoPointer += 1;
            }
        }
        answer = new int[]{equalCount + zeroCount == 6 ? 1 : equalCount + zeroCount == 5 ? 2 : equalCount + zeroCount == 4 ? 3 : equalCount + zeroCount == 3 ? 4 : equalCount + zeroCount == 2 ? 5 : 6,
                equalCount == 6 ? 1 : equalCount == 5 ? 2 : equalCount == 4 ? 3  : equalCount == 3 ? 4 : equalCount == 2 ? 5 : 6};
        return answer;
    }
}
