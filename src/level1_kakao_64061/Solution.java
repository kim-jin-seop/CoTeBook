package level1_kakao_64061;

import java.util.Stack;

public class Solution {

    public static void main(String[] args){
        solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<Integer>();
        int inputDoll = 0;

        for (int move : moves) {
            for (int i = board.length-1; i >= 0; i--) {
                if (i == 0 || board[i - 1][move-1] == 0) {
                    inputDoll = board[i][move-1];
                    board[i][move-1] = 0;
                    break;
                }
            }
            if(inputDoll == 0)
                continue;
            if(!st.isEmpty() && inputDoll == st.peek()){
                System.out.println(st.peek());
                System.out.println(inputDoll);
                st.pop();
                answer += 2;
            }
            else
                st.push(inputDoll);
        }
        return answer;
    }
}
