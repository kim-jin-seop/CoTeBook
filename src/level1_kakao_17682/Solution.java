package level1_kakao_17682;

public class Solution {
    public int solution(String dartResult) {
        final int gameset = 3;
        int answer = 0;
        int[] games = new int[gameset];

        for (int i = 0; i < gameset; i++) {
            games[i] = dartResult.charAt(0) - '0';
            if(games[i] == 1){
                if(dartResult.charAt(1) == '0'){
                    games[i] = 10;
                    dartResult = dartResult.substring(1);
                }
            }

            if (dartResult.charAt(1) == 'S') {
            } else if (dartResult.charAt(1) == 'D') {
                games[i] = games[i] * games[i];
            } else if (dartResult.charAt(1) == 'T') {
                games[i] = games[i] * games[i] * games[i];
            }

            if (dartResult.length() > 2 && dartResult.charAt(2) == '*') {
                games[i] *=2;
                if(i != 0){
                    games[i-1] *=2;
                }
                dartResult = dartResult.substring(3);
            } else if (dartResult.length() > 2 && dartResult.charAt(2) == '#') {
                games[i] *= -1;
                dartResult = dartResult.substring(3);
            } else {
                dartResult = dartResult.substring(2);
            }
        }

        for(int i = 0; i < gameset; i++){
            answer += games[i];
        }
        return answer;
    }
}