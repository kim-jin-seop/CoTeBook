package level1_problem_42576;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String,Integer> completionMap = new HashMap<String, Integer>();

        for(String completion : completions){
            int value = 1;
            if(completionMap.containsKey(completion))
                value += completionMap.get(completion);
            completionMap.put(completion,value);
        }

        for(String participant : participants){
            if(!completionMap.containsKey(participant))
                return participant;
            int value = completionMap.get(participant);
            if(value == 0)
                return participant;
            completionMap.put(participant,value-1);
        }

        return "";
    }
}
