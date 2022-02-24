# ★★☆☆☆ 124 나라의 숫자
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/12899">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/120">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
import java.util.ArrayList;

class Solution {
    public String solution(int n) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0){
            list.add(n%3);
            n = n / 3;
        }

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) == 0) {
                list.remove(i);
                list.add(i,4);
                int carry = list.remove(i + 1) - 1 ;
                list.add(i+1,carry);
            }
            if(list.get(i) < 0){
                int removeI = list.remove(i);
                list.add(i,3+removeI);
                int carry = list.remove(i + 1) - 1 ;
                list.add(i+1,carry);
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != 0)
                answer = list.get(i) + answer;
        }
        return answer;
    }
}
```

---
<Comment />
