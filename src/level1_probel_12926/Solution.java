package level1_probel_12926;

public class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == 32) {
                answer = answer + " ";
                continue;
            }

            if(s.charAt(i) >= 97){
                answer = answer + Character.toString('a' + (s.charAt(i) - 'a' + n) % 26);
            }else{
                answer = answer + Character.toString('A' + (s.charAt(i) - 'A' + n ) % 26);
            }
        }
        return answer;
    }
}
