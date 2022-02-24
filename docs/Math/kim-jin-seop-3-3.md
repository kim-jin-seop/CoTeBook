# ★★★☆☆ k진수에서 소수 개수 구하기
- 난이도 : ★★★☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/92335#">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/115">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
public class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        String value = makeJinSu(n, k,"");
        String[] values = value.split("0+");

        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("1"))
                continue;
            if (isPrime(Long.parseLong(values[i])))
                answer++;
        }
        return answer;
    }

    private boolean isPrime(long val) {
        if(val == 1L)
            return false;

        for (long j = 2; j * j <= val; j++) {
            if (val % j == 0) {
                return false;
            }
        }
        return true;
    }

    public String makeJinSu(int n, int k,String result) {
        if(n < k)
            return n%k+result;
        return makeJinSu(n/k,k,n%k + result);
    }
}```

---
<Comment />
