# ★★☆☆☆ 괄호변환
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/60058">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/130">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
import java.util.Stack;

public class Solution {
    public String solution(String p) {
        return solve(p);
    }

    public String solve(String input){
        if(input.length() == 0)
            return "";
        int checkPoint = 0;

        int find = 0;
        Stack<Character> stack = new Stack<>();
        do{
            stack.add(input.charAt(checkPoint));
            if(input.charAt(checkPoint++) == '(')
                find++;
            else
                find--;
        }while (find != 0);

        int closeCount = 0;
        boolean isRight = true;
        while (!stack.isEmpty()){
            char p = stack.pop();
            if(p == ')')
                closeCount ++;
            else
                closeCount --;
            if(closeCount < 0){
                isRight = false;
                break;
            }
        }

        if(isRight) {
            return input.substring(0, checkPoint) + solve(input.substring(checkPoint));
        }

        String result = "(" + solve(input.substring(checkPoint)) + ")";
        String u = input.substring(1,checkPoint-1);
        String reverseU = "";
        for(int i = 0; i < u.length(); i ++){
            if(u.charAt(i) == '(')
                reverseU = reverseU + ")";
            else
                reverseU = reverseU + "(";
        }
        return result + reverseU;
    }
}
```

---
<Comment />
