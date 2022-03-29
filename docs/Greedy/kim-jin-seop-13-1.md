# ★★☆☆☆ 구명보트
- 난이도 : ★★☆☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42885)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/165)
- 사용 언어 : Java

### 구현코드
```java
import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int bigPeople = people.length-1;
        int smallPeople = 0;

        int boatCount = 0;
        while (bigPeople >= smallPeople){
            boatCount++;
            if(people[smallPeople] + people[bigPeople] <= limit){
                smallPeople++;
            }
            bigPeople--;
        }
        return boatCount;
    }
}
```

---
<Comment />
