# ★☆☆☆☆ 기능 개발
- 난이도 : ★☆☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/42586">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/121">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
import java.util.ArrayList;

public class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> result = new ArrayList<>();
        int num = 0;
        while (num != progresses.length){
            develop(progresses,speeds);
            int updateCount = update(progresses, num);
            if(updateCount != 0){
                result.add(updateCount);
                num += updateCount;
            }
        }

        return result.toArray(new Integer[0]);
    }

    public void develop(int[] progresses, int[] speed){
        for(int i = 0; i < progresses.length; i++){
            progresses[i] += speed[i];
        }
    }

    public int update(int[] progresses, int now){
        int count = 0;
        for(int i = now; i < progresses.length; i++){
            if(progresses[i] > 99){
                count++;
            }
            else
                break;
        }
        return count;
    }
}
```