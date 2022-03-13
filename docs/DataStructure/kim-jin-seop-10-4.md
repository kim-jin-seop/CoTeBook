# ★☆☆☆☆ 다리를 지나가는 트럭
- 난이도 : ★☆☆☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42583)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/160)
- 사용 언어 : Java

### 구현코드
```java
package pgm_42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int count = 0;
        int roadWeight = 0;
        Queue<int[]> road = new LinkedList<>();
        int ptr = 0;

        //트럭 다리 위로 올리기
        while (ptr < truck_weights.length){
            count++;

            //트럭이 통과할 때
            if(!road.isEmpty() &&count-road.peek()[1] == bridge_length){
                int[] truck = road.remove();
                roadWeight -= truck[0];
            }

            //트럭이 올라갈 때
            if(truck_weights[ptr] + roadWeight <= weight){
                road.add(new int[]{truck_weights[ptr],count});
                roadWeight += truck_weights[ptr];
                ptr ++;
            }
            //무게 초과로 더 이상 올릴 수 없는 경우
            else{
                int[] truck = road.remove();
                roadWeight -= truck[0];
                count += truck[1] + bridge_length-count-1;
            }
        }

        //다리에 남아있는 트럭 옮기기
        while (!road.isEmpty()){
            int[] truck = road.remove();
            count += truck[1] + bridge_length-count;
        }
        return count;
    }
}

```

---
<Comment />
