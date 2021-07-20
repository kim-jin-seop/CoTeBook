package level1_kakao_17681;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String resultLine = "";

        for (int i = 0; i < n; i++) {
            resultLine = Integer.toBinaryString(arr1[i] | arr2[i]);
            while(resultLine.length() != n)
                resultLine = "0" + resultLine;
            resultLine = resultLine.replaceAll("1","#");
            resultLine = resultLine.replaceAll("0"," ");
            answer[i] = resultLine;
        }
        return answer;
    }
}