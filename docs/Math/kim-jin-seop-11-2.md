# ★★☆☆☆ 두개 이하로 다른 비트
- 난이도 : ★★☆☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/77885)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/162)
- 사용 언어 : Java

### 구현코드
```java
package pgm_77885;

public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for(long number : numbers){
            long value = solve(number);
            answer[idx++] = value;
        }
        return answer;
    }

    public long solve(long number){
        long depth = 0;
        long target = number;
        while (true){
            if((target&1) == 0){
                break;
            }
            target /= 2;
            depth++;
        }

        double addValue = Math.pow(2, depth);
        double minusValue = depth == 0 ? 0 : Math.pow(2, depth-1);
        return number + (long) addValue - (long)minusValue;
    }
}

```

---
<Comment />
