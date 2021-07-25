package level1_problem_12915;

public class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        int minIndex;
        for (int i = 0; i < strings.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < strings.length; j++) {
                if (strings[j].charAt(n) < strings[minIndex].charAt(n))
                    minIndex = j;
                else if (strings[j].charAt(n) == strings[minIndex].charAt(n))
                    if (strings[j].compareTo(strings[minIndex]) > 1)
                        minIndex = j;
            }
            String temp = strings[minIndex];
            strings[minIndex] = strings[i];
            strings[i] = temp;
        }
        answer = strings;
        return answer;
    }
}