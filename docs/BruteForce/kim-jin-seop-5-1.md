# ★★☆☆☆ 타겟 넘버
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/43165">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/125">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
public class Solution {
    public int solution(int[] numbers, int target) {
        boolean[] signs = new boolean[numbers.length];
        int answer = recursive(numbers,signs,0,target);
        return answer;
    }

    public int recursive(int[] numbers,boolean[] signs, int check,int target) {
        if(check == numbers.length){
            int result = 0;
            for(int i = 0; i < numbers.length; i++){
                int sign = signs[i] ? 1 : -1;
                result += numbers[i] * sign;
            }
            if(result == target)
                return 1;
            else
                return 0;
        }
        signs[check] = false;
        int value1 = recursive(numbers,signs,check+1,target);
        signs[check] = true;
        int value2 = recursive(numbers,signs,check+1,target);
        return value1 + value2;
    }
}
```