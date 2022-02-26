package level1_problem_42862;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+1];

        for(int i : lost){
            students[i] -= 1;
        }
        for(int i : reserve){
            students[i] += 1;
        }

        //data -1 / 0 / 1
        for(int i = 1; i < students.length; i++){
            if(students[i] == -1){
                if(i+1 != students.length && students[i+1] == 1){
                    students[i+1] --;
                    answer ++;
                }
                else if(students[i-1] == 1){
                    answer ++;
                }
            }
            else if(students[i] == 0 || students[i] == 1){
                answer++;
            }
        }
        return answer;
    }
}