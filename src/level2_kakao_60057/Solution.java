package level2_kakao_60057;

public class Solution {

    public static void main(String args[]){
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        int min = s.length();
        for (int count = 1; count <= s.length() / 2; count++) {
            int length = findLength(s, count);
            if (min > length)
                min = length;
        }
        return min;
    }

    private static int findLength(String s, int count) {
        int length = 0;
        String before = "";
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i += count) {
            if (!before.equals(s.substring(i, i + count))) {
                before = s.substring(i, i + count);
                length += count;
                isFirst = true;
            } else {
                if (isFirst)
                    length += 1;
                isFirst = false;
            }

            if(i+count > s.length())
                return length + (s.length()-i);
        }
        return length;
    }
}