package pgm_42626;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        ArrayList<Integer> scovilles = new ArrayList<>();

        for(int i = 0 ; i < scoville.length; i++){
            scovilles.add(scoville[i]);
        }
        Collections.sort(scovilles);

        while(scovilles.get(0) <= K){
            answer ++;

            int second = scovilles.remove(1);
            int first = scovilles.remove(0);
            int newSpicy = first + 2*second;

            if(scovilles.size() == 0)
                if(newSpicy < K)
                    return -1;
                else
                    return answer;

            for(int i = 0; i < scovilles.size(); i++){
                int value = scovilles.get(i);
                if(value > newSpicy){
                    scovilles.add(i,newSpicy);
                    break;
                }
                if(i == scovilles.size()-1) {
                    scovilles.add(newSpicy);
                    break;
                }
            }

        }

        return answer;
    }
}