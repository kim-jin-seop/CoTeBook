# ★☆☆☆☆ 주식가격
- 난이도 : ★☆☆☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42584?language=java)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/164)
- 사용 언어 : Java

### 구현코드
```java
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        PriorityQueue<Price> maxHeap = new PriorityQueue<>();
        for(int i = 0; i< prices.length; i++){
            Price inputPrice = new Price(i, prices[i]);
            maxHeap.add(inputPrice);
            while (!maxHeap.isEmpty() && maxHeap.peek().value > inputPrice.value){
                Price removePrice = maxHeap.remove();
                answer[removePrice.idx] = inputPrice.idx - removePrice.idx;
            }
        }

        while (!maxHeap.isEmpty()){
            Price removePrice = maxHeap.remove();
            answer[removePrice.idx] = prices.length - removePrice.idx-1;
        }
        return answer;
    }

    public class Price implements Comparable<Price> {
        int idx;
        int value;

        public Price(int i, int p){
            idx = i;
            value = p;
        }

        @Override
        public int compareTo(Price o) {
            return o.value == this.value ? 0 : o.value > this.value ? 1 : -1;
        }
    }
}
```

---
<Comment />
