# ★☆☆☆☆ 짝지어 제거하기
- 난이도 : ★☆☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/12973">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/126">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
import java.util.Stack;

public class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.add(s.charAt(i)-'0');
                continue;
            }

            int front = stack.pop();
            int back = s.charAt(i) -'0';

            if(front == back)
                continue;
            stack.add(front);
            stack.add(back);
        }

        if (stack.isEmpty())
            return 1;
        return 0;
    }
}
```

---
<Comment />
