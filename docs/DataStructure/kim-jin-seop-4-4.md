# ★☆☆☆☆ 더 맵게
- 난이도 : ★☆☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/42626#">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/124">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
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
```

---
<Comment />
