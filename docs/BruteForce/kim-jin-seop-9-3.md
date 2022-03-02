# ★★★☆☆ 후보키
- 난이도 : ★★★☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42890) 
- [풀이 바로가기](https://cnu-jinseop.tistory.com/153)
- 사용 언어 : Java

### 구현코드
```java
package pgm_42890;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int solution(String[][] relation) {

        boolean[] used = new boolean[relation[0].length];
        Set<String> keys = new HashSet<>();
        makeKeyRecursive(0,used, relation, keys);

        String[] infoAboutKey = keys.toArray(new String[0]);
        int count = keys.stream()
                .filter((s) -> {
                    //각 문자들로 순회하며 확인
                    for (int i = 0; i < infoAboutKey.length; i++) {
                        boolean isContain = true;
                        for(int j = 0; j < infoAboutKey[i].length(); j++){
                            if(!s.contains(infoAboutKey[i].charAt(j) +"")) {
                                isContain = false;
                                break;
                            }
                        }
                        if (isContain && !s.equals(infoAboutKey[i]))
                            return false;
                    }
                    return true;
                }).collect(Collectors.toList()).size();
        return count;
    }

    /**
     * 완전 탐색
     * @param point 칼럼을 사용할지 말지 고르는 포인터
     * @param used 사용하는 칼럼 = true, 사용 안하는 칼럼 = false
     * @param relation 주어진 relation
     * @param keys 슈퍼키
     */
    public void makeKeyRecursive(int point, boolean[] used, String[][] relation , Set<String> keys){
        if(point == relation[0].length){
            Set<String> check = new HashSet<>();
            for(int i = 0; i < relation.length; i++){
                // 튜플 구하여 슈퍼키인지 확인
                String tuple = "";
                for(int j = 0; j < relation[i].length; j++){
                    if(used[j])
                        tuple += relation[i][j];
                }
                if(check.contains(tuple))
                    return;
                if(tuple.equals(""))
                    return;
                check.add(tuple);
            }

            // 슈퍼키 일 경우
            String key = "";
            for(int i = 0; i < used.length; i++){
                if(used[i])
                    key += i;
            }
            keys.add(key);
            return;
        }

        //재귀로 돌며 모든 경우를 탐색
        makeKeyRecursive(point+1,used,relation,keys);
        used[point] = true;
        makeKeyRecursive(point+1,used,relation,keys);
        used[point] = false;
    }
}

```

---
<Comment />
