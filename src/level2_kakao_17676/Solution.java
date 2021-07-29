package level2_kakao_17676;

public class Solution {
    public int solution(String[] lines) {
        int maxThroughput = 0, nowThroughput = 0;

        for(int i = 0; i < lines.length; i++){
            String[] splitData = lines[i].split(" ");
            String[] serviceStartTime = splitData[1].split(":");
            String processingTime = splitData[2].substring(0,splitData[2].length()-1);

            String startTime_Hour = serviceStartTime[0];
            String startTime_Min = serviceStartTime[1];
            String startTime_Sec = serviceStartTime[2];


        }
        return 0;
    }
}