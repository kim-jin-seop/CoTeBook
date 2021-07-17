package level1_kakao_72410;

public class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        String temp = "";

        //level 2
        answer = answer.replaceAll("[^a-zA-Z0-9._-]", "");
        //level 3
        answer = answer.replaceAll("[.]+", ".");
        //level 4
        if (answer.charAt(0) == '.')
            answer = answer.substring(1);
        //level 5
        if (answer.equals("")) {
            answer = "a";
        }
        //level 6
        answer = answer.substring(0, answer.length() > 15 ? 15 : answer.length());
        if (answer.charAt(answer.length() - 1) == '.')
            answer = answer.substring(0, answer.length() - 1);

        //level 1
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (64 < c && c < 91)
                c += 32;
            temp += c;
        }
        answer = temp;

        temp = answer.charAt(answer.length()-1) + "";
        //level 7
        while (answer.length() < 3)
            answer = answer + temp;

        return answer;
    }
}
