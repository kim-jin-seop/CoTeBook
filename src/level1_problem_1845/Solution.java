package level1_problem_1845;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int choiceNum = nums.length/2;
        boolean[] choiceMonster = new boolean[200001];

        for(int i = 0; i < nums.length; i++){
            if(!choiceMonster[nums[i]]){
                choiceMonster[nums[i]] = true;
                answer++;
            }
        }
        return answer < choiceNum ? answer : choiceNum;
    }
}