package level1_problem_42748;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] cutArray;
        int min, temp, index = 0;

        for(int[] command : commands){
            cutArray = new int[command[1]-command[0]+1];
            for(int i = command[0];i <= command[1]; i++) {
                cutArray[i - command[0]] = array[i - 1];
            }
            for(int i = 0; i < command[2]; i ++){
                min = i;
                for(int j = i+1; j < cutArray.length; j ++){
                    if(cutArray[min] > cutArray[j])
                        min = j;
                }
                temp = cutArray[i];
                cutArray[i] = cutArray[min];
                cutArray[min] = temp;
            }
            answer[index++] = cutArray[command[2]-1];
        }
        return answer;
    }
}