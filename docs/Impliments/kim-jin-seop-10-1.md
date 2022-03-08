# ★★☆☆☆ 괄호 회전하기
- 난이도 : ★★☆☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/76502)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/155)
- 사용 언어 : Java

### 구현코드
```java
package pgm_76502;

import java.util.Stack;
import java.util.function.Predicate;

public class Solution {
    public int solution(String s) {
        int moveCount = 0; //회전하는 횟수
        int count = 0; // 총 괄호의 수
        while (moveCount != s.length()){ //한 바퀴만 확인
            String check = ""; // 문자단위로 쪼개서 체크
            for(int i = 0; i < s.length(); i++){
                check = check + s.charAt(i);
                if(isCorrect(check)){
                    check = "";
                    count ++;
                }
            }
            if(!check.equals("")) { // 해당 문자열을 모두 확인하였을 때 check가 비어있지 않다면 남은 괄호가 있다는 의미
                count = 0;
                s = rotate(s);
                moveCount++;
            }
            else // 올바른 괄호들로 구성된 문자열
                break;
        }
        return count;
    }

    // 주어진 문자열이 올바른 괄호열인지 확인
    private boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        Predicate<Character> isOpen = c -> c == '[' || c == '(' || c == '{'; // 여는 괄호이면 true

        for(int i = 0; i < s.length(); i++){
            if(isOpen.test(s.charAt(i))) // 여는 괄호는 Stack에 add
                stack.add(s.charAt(i));
            else{
                if(stack.isEmpty() || !isPare(stack.pop(),s.charAt(i))) // 닫는 괄호는 Stack에 있는 여는 괄호와 비교
                    return false; //만약 여는 괄호가 같은 쌍이 아니거나 닫는 괄호가 먼저 나오는 경우
            }
        }
        if(stack.isEmpty()) // 올바른 문자열
            return true;
        else
            return false;
    }

    private boolean isPare(Character open, Character close){ // 같은 쌍인지 비교
        return (open == '{' && close == '}') || (open == '[' && close == ']') || (open == '(' && close == ')');
    }

    private String rotate(String s){ //1회 회전
        return s.substring(1) + s.charAt(0);
    }
}
```

---
<Comment />
