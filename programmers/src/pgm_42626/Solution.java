package pgm_42626;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0 ; i < scoville.length; i++){
            minHeap.add(scoville[i]);
        }

        while(minHeap.peek() < K){
            answer ++;
            int first = minHeap.remove();
            int second = minHeap.remove();
            int newSpicy = first + 2*second;

            if(minHeap.size() == 0)
                if(newSpicy < K)
                    return -1;
                else
                    return answer;

            minHeap.add(newSpicy);
        }

        return answer;
    }
}