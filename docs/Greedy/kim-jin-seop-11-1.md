# ★★★★☆ 큰 수 만들기
- 난이도 : ★★★★☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42883)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/161)
- 사용 언어 : Java

### 구현코드
```java
package pgm_42883;

public class Solution {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder();

        int idx = 0;
        int max;
        for(int i = 0; i < number.length()-k; i++){
            max = 0;
            for(int j = idx; j <= i+k; j++){
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            builder.append(max);
        }
        return builder.toString();
    }
}
```

---
<Comment />
