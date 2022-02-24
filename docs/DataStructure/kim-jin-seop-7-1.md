# ★★☆☆☆ 튜플
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/64065">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/135">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public Integer[] solution(String s) {
        s = s.substring(1,s.length()-1);
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            String value = "";
            if(s.charAt(i) == '{'){
                while (s.charAt(++i) != '}'){
                    value =  value + s.charAt(i);
                }
                list.add(value);
            }
        }

        String[] values = list.toArray(new String[0]);
        Arrays.sort(values,(o1,o2) -> o1.length() > o2.length() ? 1 : -1);

        ArrayList<Integer> tuple = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(String value : values){
            String[] splitValue = value.split(",");

            for(String v : splitValue){
                if(!set.contains(Integer.parseInt(v))){
                    tuple.add(Integer.parseInt(v));
                    set.add(Integer.parseInt(v));
                }
            }
        }
        return tuple.toArray(new Integer[0]);
    }
}
```