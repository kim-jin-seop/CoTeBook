package pgm_42888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] solution(String[] records) {

        ArrayList<String[]> logs = new ArrayList<>();
        Map<String, String> nameMap = new HashMap<>();
        for(String record : records){
            String[] log = new String[2];
            String[] splitRecord = record.split(" ");
            if(!splitRecord[0].equals("Change")) {
                log[0] = splitRecord[0];
                log[1] = splitRecord[1];
                logs.add(log);
            }
            if(!splitRecord[0].equals("Leave")) {
                nameMap.put(splitRecord[1], splitRecord[2]);
            }
        }

        String[] answer = new String[logs.size()];
        for(int i = 0; i < logs.size(); i++){
            String[] log = logs.get(i);
            if(log[0].equals("Enter")){
                answer[i] = nameMap.get(log[1]) + "님이 들어왔습니다.";
            }
            else{
                answer[i] = nameMap.get(log[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}