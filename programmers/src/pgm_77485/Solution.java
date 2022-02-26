package pgm_77485;

public class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];

        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = val++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            matrix = rotateMatrix(queries[i], matrix);
            int min = findMin(queries[i], matrix);
            answer[i] = min;
        }

        return answer;
    }

    public int findMin(int[] query, int[][] matrix){
        int min = Integer.MAX_VALUE;
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;

        //윗면과 밑면
        for(int i = x1; i <= x2; i++){
            if(min > matrix[i][y1])
                min = matrix[i][y1];
            if(min > matrix[i][y2])
                min = matrix[i][y2];
        }

        //옆면
        for(int i = y1; i <= y2; i++){
            if(min > matrix[x1][i])
                min = matrix[x1][i];
            if(min > matrix[x2][i])
                min = matrix[x2][i];
        }

        return min;
    }

    public int[][] rotateMatrix(int[] query, int[][] matrix) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultMatrix[i][j] = matrix[i][j];
            }
        }

        //윗면
        for (int i = y1; i < y2; i++) {
            resultMatrix[x1-1][i] = matrix[x1-1][i - 1];
        }
        //오른쪽 면
        for (int i = x1; i < x2; i++) {
            resultMatrix[i][y2-1] = matrix[i - 1][y2-1];
        }

        // 밑면
        for (int i = y2 - 2; i >= y1 - 1; i--) {
            resultMatrix[x2-1][i] = matrix[x2-1][i + 1];
        }

        //왼쪽 면
        for (int i = x2 - 2; i >= x1 - 1; i--) {
            resultMatrix[i][y1-1] = matrix[i + 1][y1-1];
        }
        return resultMatrix;
    }
}
