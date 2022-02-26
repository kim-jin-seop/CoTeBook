package level3_kakao_17676;

import java.time.*;
import java.util.ArrayList;


public class Solution {

    public int solution(String[] lines) {
        ArrayList<LocalDateTime> finishTimes = new ArrayList<>();
        ArrayList<LocalDateTime> startTimes = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String[] splitline = lines[i].split(" ");
            LocalDate date = LocalDate.parse(splitline[0]);
            LocalTime time = LocalTime.parse(splitline[1]);
            finishTimes.add(LocalDateTime.of(date, time).minusSeconds(-1).minusNanos(1000000 * 1));

            String[] seconds = splitline[2].split("[.s]");
            if (seconds.length == 2)
                startTimes.add(LocalDateTime.of(date, time)
                        .minusSeconds(Integer.parseInt(seconds[0]))
                        .minusNanos(1000000 * Integer.parseInt(seconds[1]))
                        .minusNanos(1000000 * -1));
            else
                startTimes.add(LocalDateTime.of(date, time)
                        .minusSeconds(Integer.parseInt(seconds[0]))
                        .minusNanos(1000000 * -1));
        }

        int max = findMax(finishTimes, startTimes);
        return max;
    }

    private int findMax(ArrayList<LocalDateTime> finishTimes, ArrayList<LocalDateTime> startTimes) {
        int max = 0;
        for (int i = 0; i < finishTimes.size(); i++) {
            int count = 0;
            for (int j = i; j < startTimes.size(); j++) {
                if (!startTimes.get(j).isAfter(finishTimes.get(i)))
                    count++;
            }
            if (count > max)
                max = count;
        }
        return max;
    }
}