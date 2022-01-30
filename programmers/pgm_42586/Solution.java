package pgm_42586;

import java.util.ArrayList;

public class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> result = new ArrayList<>();
        int num = 0;
        while (num != progresses.length){
            develop(progresses,speeds);
            int updateCount = update(progresses, num);
            if(updateCount != 0){
                result.add(updateCount);
                num += updateCount;
            }
        }

        return result.toArray(new Integer[0]);
    }

    public void develop(int[] progresses, int[] speed){
        for(int i = 0; i < progresses.length; i++){
            progresses[i] += speed[i];
        }
    }

    public int update(int[] progresses, int now){
        int count = 0;
        for(int i = now; i < progresses.length; i++){
            if(progresses[i] > 99){
                count++;
            }
            else
                break;
        }
        return count;
    }
}