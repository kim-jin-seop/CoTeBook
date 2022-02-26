package pgm_92334;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> reportMemberList = new HashMap<>();
        Map<String, Integer> getMailCount = new HashMap<>();
        for(String id : id_list){
            getMailCount.put(id,0);
            reportMemberList.put(id,new HashSet<>());
        }

        for(String rep : report){
            String[] checkReport = rep.split(" ");
            reportMemberList.get(checkReport[1]).add(checkReport[0]);
        }

       for(String key : reportMemberList.keySet()){
           HashSet<String> reporters = reportMemberList.get(key);
           if(reporters.size() >= k){
               for(String reporter : reporters){
                   Integer getMail = getMailCount.get(reporter);
                   getMailCount.put(reporter,getMail+1);
               }
           }
       }

       int[] answer = new int[id_list.length];
       for(int i = 0; i < answer.length; i++){
           answer[i] = getMailCount.get(id_list[i]);
       }
        return answer;
    }
}