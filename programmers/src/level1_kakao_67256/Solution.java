package level1_kakao_67256;

public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left = {1,4};
        int[] right = {3,4};
        int[] center = new int[2];
        int leftLength, rightLength;
        for(int num : numbers){
            switch(num){
                case 1 :
                case 4 :
                case 7 :
                    answer += "L";
                    left = num == 1 ? new int[]{1, 1} : num == 4 ? new int[]{1, 2} : new int[]{1, 3};
                    break;
                case 3 :
                case 6 :
                case 9 :
                    answer += "R";
                    right = num == 3 ? new int[]{3, 1} : num == 6 ? new int[]{3, 2} : new int[]{3, 3};
                    break;
                case 2 :
                case 5 :
                case 8 :
                case 0 :
                    center = num == 2 ? new int[]{2, 1} : num == 5 ? new int[]{2, 2} : num == 8 ? new int[]{2, 3} : new int[]{2, 4};
                    leftLength = Math.abs(center[0] - left[0]) + Math.abs(center[1] - left[1]);
                    rightLength = Math.abs(center[0] - right[0]) + Math.abs(center[1] - right[1]);;
                    if(leftLength > rightLength){
                        answer += "R";
                        right = center;
                    }
                    else if(leftLength < rightLength){
                        answer += "L";
                        left = center;
                    }
                    else{
                        if(hand.equals("left")){
                            answer += "L";
                            left = center;
                        }
                        else{
                            answer += "R";
                            right = center;
                        }
                    }
            }
        }
        return answer;
    }
}