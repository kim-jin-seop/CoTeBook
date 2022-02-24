# ★★★☆☆ 양궁대회
- 난이도 : ★★★☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/92342">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/118">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드(실패..)
```java
public class Solution {
    int[] result = new int[11];
    int maxPoint = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        int[] answer;
        boolean[] check = new boolean[10];
        shot(n, 0, info, new int[11], check);
        if (maxPoint <= 0)
            answer = new int[]{-1};
        else
            answer = result;
        return answer;
    }

    public void shot(int n, int idx, int[] info, int[] shots, boolean[] check) {
        if (n == idx) {
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    n -= (info[i] + 1);
                    shots[i] = info[i] + 1;
                }
                else{
                    shots[i] = 0;
                }
            }
            if (n < 0)
                return;
            shots[10] = n;

            int calPoint = calPoint(info, shots);
            if (calPoint > maxPoint) {
                maxPoint = calPoint;
                for (int i = 0; i < result.length; i++) {
                    result[i] = shots[i];
                }
            } else if (calPoint == maxPoint) {
                boolean change = false;
                for (int i = result.length - 1; i >= 0; i--) {
                    if (result[i] < shots[i]) {
                        change = true;
                        break;
                    }
                }
                if (change) {
                    for (int i = 0; i < result.length; i++) {
                        result[i] = shots[i];
                    }
                }
            }
            return;
        }
        check[idx] = true;
        shot(n, idx + 1, info, shots, check);
        check[idx] = false;
        shot(n, idx + 1, info, shots, check);

    }

    public int calPoint(int[] info, int[] shots) {
        int point = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && shots[i] == 0)
                continue;
            if (info[i] < shots[i])
                point += (10 - i);
            else
                point -= (10 - i);
        }
        return point;
    }
}
```

---
<Comment />
