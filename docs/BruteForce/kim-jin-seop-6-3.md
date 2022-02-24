# ★★☆☆☆ 거리두기 확인하기
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/81302">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/132">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = check(makePosition(places[i])) ? 1 : 0;
        }
        return answer;
    }

    private char[][] makePosition(String[] place) {
        char[][] positions = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                positions[i][j] = place[i].charAt(j);
            }
        }
        return positions;
    }

    public boolean check(char[][] positions) {
        boolean result = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (result) {
                    boolean[][] checked = new boolean[5][5];
                    result = isKeepDistance(positions, checked, i, j, 0);
                }
            }
        }
        return result;
    }

    public boolean isKeepDistance(char[][] positions, boolean[][] checked, int x, int y, int depth) {
        if (!(x < 5 && x >= 0 && y >= 0 && y < 5 && !checked[x][y]))
            return true;
        if (depth == 3)
            return true;
        if (positions[x][y] == 'P' && depth != 0)
            return false;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        checked[x][y] = true;
        if (positions[x][y] == 'P') {
            for (int i = 0; i < dx.length; i++) {
                if (!isKeepDistance(positions, checked, x + dx[i], y + dy[i], depth + 1))
                    return false;
            }
        } else if (positions[x][y] == 'X')
            return true;
        else {
            if (depth == 0)
                return true;
            for (int i = 0; i < dx.length; i++) {
                if (!isKeepDistance(positions, checked, x+dx[i], y+dy[i], depth + 1))
                    return false;
            }
        }
        return true;
    }
}
```

---
<Comment />
