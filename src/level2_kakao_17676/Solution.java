package level2_kakao_17676;

import java.sql.Time;
import java.time.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String args[]){
        Time t = new Time(22);
    }
    public int solution(String[] lines) {
        String[][] worksTime = new String[lines.length][2];
        ArrayList<LocalDateTime> finishTimes = new ArrayList<>();
        ArrayList<LocalDateTime> startTimes = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String[] splitline = lines[i].split(" ");
            LocalDate date = LocalDate.parse(splitline[0]);
            LocalTime time = LocalTime.parse(splitline[1]);
            finishTimes.add(LocalDateTime.of(date,time.minusSeconds(-1)));
            startTimes.add(LocalDateTime.of(date,time)
                    .minusNanos(1000000000L*Long.parseLong(splitline[2].substring(0,splitline[2].length()-1)+0.01)));
        }
        int max = 0;
        int count = 0;
        for(int i = 0; i < finishTimes.size(); i++){
            for(int j = i; j < startTimes.size(); j++){
                if(finishTimes.get(i).isBefore(startTimes.get(j)))
                    count++;
            }
            if(count > max)
                max = count;
        }
        return max;
    }
}