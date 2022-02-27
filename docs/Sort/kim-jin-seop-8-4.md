# ★★☆☆☆ 전화번호 목록
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/42577">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/144">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
package pgm_42577;

import java.util.Arrays;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        //사전식 정렬 수행
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length-1; i++){
            String prefix = phone_book[i]; // prefix가 될 수 있는 부분
            if(prefix.length() > phone_book[i+1].length()) //서로 다른 prefix를 갖고있는경우
                continue;
            String val = phone_book[i+1].substring(0, prefix.length()); //뒤 부부의 전화번호를 prefix만큼 자름 비교를 위해
            if(prefix.equals(val)){
                answer = false;
                break;
            }
            System.out.println("phone_book[i] = " + phone_book[i]);
        }
        return answer;
    }
}

```

---
<Comment />
