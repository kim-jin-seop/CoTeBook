package level1_problem_12977;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num;

        for(int i = 0; i< nums.length -2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++){
                    num = nums[i] + nums[j] + nums[k];
                    for(int n = 2; n <= num; n++){
                        if(num % n == 0){
                            if(num == n){
                                answer ++;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}