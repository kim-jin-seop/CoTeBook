# ★★★☆☆ 멀쩡한 삼각형
- 난이도 : ★★★☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/62048">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/119">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = gcd(w, h);
        long remove = ((h / gcd) + (w / gcd) - 1) * gcd;
        answer = ((long)w * (long)h) - remove;
        return answer;
    }

    public int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
```