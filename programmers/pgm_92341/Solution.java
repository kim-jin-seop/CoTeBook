package pgm_92341;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, String> inTime = new HashMap<>();
        Map<String, Integer> accumulationTime = new HashMap<>();

        for(String record : records){
            String[] recordSplit = record.split(" ");
            String time = recordSplit[0];
            String carNumber = recordSplit[1];

            if(recordSplit[2].equals("IN")){
                inTime.put(carNumber,time);
            }
            else{
                String parkingInTime = inTime.get(carNumber);

                int pastTime = 0;
                if(accumulationTime.containsKey(carNumber)){
                    pastTime += accumulationTime.get(carNumber);
                }
                accumulationTime.put(carNumber,calcParkingTime(parkingInTime, time) + pastTime);
                inTime.remove(carNumber);
            }
        }

        for(String carNumber : inTime.keySet()){
            int pastTime = 0;
            String parkingInTime = inTime.get(carNumber);
            if(accumulationTime.containsKey(carNumber)){
                pastTime += accumulationTime.get(carNumber);
            }
            accumulationTime.put(carNumber,calcParkingTime(parkingInTime, "23:59") + pastTime);
        }

        String[] carNumbers = accumulationTime.keySet().toArray(new String[0]);
        Arrays.sort(carNumbers);
        answer = new int[carNumbers.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = settlementFee(accumulationTime.get(carNumbers[i]),fees);
        }

        return answer;
    }

    public int settlementFee(int accumulationTime, int[] fees){
        if(accumulationTime <= fees[0])
            return fees[1];
        accumulationTime -= fees[0];
        return fees[1]+(((accumulationTime % fees[2] == 0 ? 0 : 1) + (accumulationTime / fees[2]))*fees[3]);
    }

    public int calcParkingTime(String parkingInTime, String parkingOutTime){
        String[] splitInTime = parkingInTime.split(":");
        String[] splitOutTime = parkingOutTime.split(":");
        return (Integer.parseInt(splitOutTime[0])*60 + Integer.parseInt(splitOutTime[1])) - (Integer.parseInt(splitInTime[0])*60 + Integer.parseInt(splitInTime[1]));
    }

}