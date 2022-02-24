# ★★☆☆☆ 가장 큰 수
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/42746">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/138">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
import java.util.*;

public class Solution {
    public String solution(int[] numbers) {

        List<Integer> numberList = new ArrayList<>();
        for(int number : numbers)
            numberList.add(number);

        Collections.sort(numberList,
                (o1, o2)-> {
                    String front = String.valueOf(o1);
                    String back = String.valueOf(o2);
                    return Integer.parseInt(front + back) < Integer.parseInt(back + front) ? 1 :
                            Integer.parseInt(front + back) == Integer.parseInt(back + front) ? 0 : -1;
                });

        String result = "";
        long sum = 0;
        for(int number : numberList){
            result = result + number;
            sum += number;
            sum %= Integer.MAX_VALUE;
        }
        if(sum == 0)
            result = "0";
        return result;
    }
}
```