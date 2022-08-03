# ★☆☆☆☆ 점프와 순간이동
- 난이도 : # ★☆☆☆☆
- [문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12980)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/183)
- 사용 언어 : Python

### 구현코드
```python
def solution(n):
    ans = 0
    while n != 0:
        if n%2 == 0:
            n = n/2
        elif n%2 == 1:
            n = n-1
            ans = ans+1
    return ans
```

---
<Comment />
