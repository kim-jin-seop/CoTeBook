package level2_kakao_60057;

public class Solution {

    public int solution(String s) {
        int min = s.length();
        for (int count = 1; count <= s.length() / 2; count++) {
            int length = findLength(s, count);
            if (min > length)
                min = length;
        }
        return min;
    }

    private int findLength(String s, int count) {
        int length = 0;
        int numCount = 1;
        String before = "";
        for (int i = 0; i < s.length(); i += count) {
            if(i+count > s.length())
                return length + (s.length()-i) + (numCount != 1 ? String.valueOf(numCount).length() : 0);
            if (!before.equals(s.substring(i, i + count))) {
                before = s.substring(i, i + count);
                length += count + (numCount != 1 ? String.valueOf(numCount).length() : 0);
                numCount = 1;
            } else {
                numCount++;
            }
        }
        return length + (numCount != 1 ? String.valueOf(numCount).length() : 0);
    }
}