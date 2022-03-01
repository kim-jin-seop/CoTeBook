# ★★★★☆ 순위 검색
- 난이도 : ★★★★☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/72412)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/149)
- 사용 언어 : Java

### 구현코드
```java
package pgm_72412;

import java.util.*;

public class Solution {
    public Integer[] solution(String[] info, String[] query) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, ArrayList<Integer>> db = new HashMap<>();
        processInfo(db, info);
        sortDB(db);
        for (String q : query)
            answer.add(processQuery(db, q));
        return answer.toArray(new Integer[0]);
    }

    /**
     * DB에 List를 정렬
     * @param db
     */
    public void sortDB(Map<String, ArrayList<Integer>> db){
        Set<String> keys = db.keySet();
        for(String key : keys){
            ArrayList<Integer> list = db.get(key);
            list.sort(Comparator.naturalOrder());
            db.put(key,list);
        }
    }

    /**
     * info에서 key와 score값을 추출하여 DB에 insert
     * @param db
     * @param infos
     */
    public void processInfo(Map<String, ArrayList<Integer>> db, String[] infos) {
        for (String info : infos) {
            String query = info.replaceAll("[0-9]", "");
            query = query.trim();
            int score = Integer.parseInt(info.replaceAll("[^0-9]", ""));
            insertDB(db,query,score);
        }
    }

    /**
     * db에서 insert되는 과정
     * 이 때 key로 만들수 있는 16가지를 배열로 선언하여 삽입할 때 함께 삽입해줌.
     * @param db
     * @param info
     * @param score
     */
    public void insertDB(Map<String, ArrayList<Integer>> db, String info,  int score){
        String[] splitInfo = info.split(" ");

        String[] lang = {"-","-","-","-",splitInfo[0],splitInfo[0],splitInfo[0],splitInfo[0],"-","-","-",splitInfo[0],splitInfo[0],splitInfo[0],"-",splitInfo[0]};
        String[] part = {"-","-","-",splitInfo[1],"-",splitInfo[1],"-","-",splitInfo[1],splitInfo[1],"-",splitInfo[1],splitInfo[1],"-",splitInfo[1],splitInfo[1]};
        String[] career = {"-","-",splitInfo[2],"-","-","-",splitInfo[2],"-",splitInfo[2],"-",splitInfo[2],splitInfo[2],"-",splitInfo[2],splitInfo[2],splitInfo[2]};
        String[] food = {"-",splitInfo[3],"-","-","-","-","-",splitInfo[3],"-",splitInfo[3],splitInfo[3],"-",splitInfo[3],splitInfo[3],splitInfo[3],splitInfo[3]};
        for(int i = 0; i < lang.length; i++){
            String key = lang[i] + part[i] +  career[i]  + food[i];
            ArrayList<Integer> list;
            if (db.containsKey(key))
                list = db.get(key);
            else
                list = new ArrayList<>();
            list.add(score);
            db.put(key, list);
        }
    }

    /**
     * Query를 처리하는 메소드
     * @param db
     * @param query
     * @return
     */
    public int processQuery(Map<String, ArrayList<Integer>> db, String query) {
        String[] splitQuery = query.split(" and ");

        String lang = splitQuery[0];
        String part = splitQuery[1];
        String career = splitQuery[2];
        String food = splitQuery[3].split(" ")[0];

        String key = lang + part  + career + food;
        int score = Integer.parseInt(query.replaceAll("[^0-9]", ""));
        if(!db.containsKey(key))
            return 0;

        /**
         * 이분탐색
         */
        ArrayList<Integer> scores = db.get(key);
        int left = 0;
        int right = scores.size()-1;
        int mid = 0;
        while (right >= left){
            mid = (right + left)/2;
            if(scores.get(mid) >= score)
                break;
            left = mid + 1;
        }
        for(;mid != -1 && scores.get(mid) >= score; mid--);
        return scores.size() - mid-1;

    }
}
```

---
<Comment />
