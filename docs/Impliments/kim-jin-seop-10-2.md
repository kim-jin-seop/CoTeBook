# ★★☆☆☆ 배달
- 난이도 : ★★☆☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/12978)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/157)
- 사용 언어 : Java

### 구현코드
```java
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int solution(int N, int[][] road, int K) {
        Map<Village, Integer> map = new HashMap<>();
        int[] distance = new int[N + 1];
        for (int i = 2; i < N + 1; i++)
            distance[i] = -1;

        connectRoad(road, map); // 길 연결
        findShortestDistanceByA(map, distance, 1, N); //최단거리 구하기

        int count = 0;
        for (int i = 1; i < N + 1; i++)
            if (distance[i] != -1 && distance[i] <= K)
                count++;
        return count;
    }

    public void connectRoad(int[][] road, Map<Village, Integer> map) {
        for (int i = 0; i < road.length; i++) {
            int vilA = road[i][0]; // 마을1
            int vilB = road[i][1]; // 마을 2
            int weight = road[i][2]; // 가중치

            Village forward = new Village(vilA, vilB);
            Village reverse = new Village(vilB, vilA);

            if (map.containsKey(forward)) {
                weight = map.get(forward) < weight ? map.get(forward) : weight;
            }
            map.put(forward, weight); // 마을2, 마을1로 이어줌
            map.put(reverse, weight); // 마을1, 마을2로 이어줌
        }
    }

    public void findShortestDistanceByA(Map<Village, Integer> map, int[] distance, int now, int N) {
        for (int i = 1; i <= N; i++) {
            Village village = new Village(now, i);
            if (!map.containsKey(village)) //만약 길이 연결되어 있지 않다면
                continue;
            Integer weight = map.get(village);
            if (distance[i] > distance[now] + weight || distance[i] == -1) {
                distance[i] = distance[now] + weight;
                findShortestDistanceByA(map, distance, i, N); //연결된 마을에 대하여 다시 확인
            }
        }
    }


    public class Village {
        private int vilA;
        private int vilB;

        public Village(int vilA, int vilB) {
            this.vilA = vilA;
            this.vilB = vilB;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Village village = (Village) o;
            return vilA == village.vilA && vilB == village.vilB;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vilA, vilB);
        }
    }
}
```

---
<Comment />
