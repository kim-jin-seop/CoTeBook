# ★★☆☆☆ 프렌즈 4블럭
- 난이도 : ★★☆☆☆
- [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/17679)
- [풀이 바로가기](https://cnu-jinseop.tistory.com/158)
- 사용 언어 : Java

### 구현코드
```java
package pgm_17679;

public class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] c_board = new char[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0;  j < n; j++){
                c_board[i][j] = board[i].charAt(j);
            }
        }
        boolean change;
        do {
            boolean[][] checked = new boolean[m][n];
            change = breakBlock(m,n,c_board,checked);
            removeBlock(m,n,c_board,checked);
            moveDownBlock(m,n,c_board);
        }while (change);

        moveDownBlock(m,n,c_board);
        return removedBlockCount(m,n,c_board);
    }

    public int removedBlockCount(int m, int n, char[][] board){
        int count = 0;
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '-')
                    count++;
            }
        }
        return count;
    }

    public void moveDownBlock(int m, int n, char[][] board){
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(board[i][j] == '-'){
                    filledBlock(i,j,m,n,board);
                }
            }
        }
    }

    private void filledBlock(int x, int y, int m, int n, char[][] board){
        boolean valid = false;
        for(int k = 0; k+x > 0; k--){
            if(!valid && board[k+x-1][y] != '-')
                valid = true;
            char temp = board[k+x][y];
            board[k+x][y] = board[k+x-1][y];
            board[k+x-1][y] = temp;
        }

        if(valid && board[x][y] == '-')
            filledBlock(x,y,m,n,board);
    }

    public void removeBlock(int m, int n, char[][] board, boolean[][] checked){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(checked[i][j])
                    board[i][j] = '-';
            }
        }
    }

    public boolean breakBlock(int m, int n, char[][] board, boolean[][] checked){
        int[][] dx = {{-1,-1,0},{-1,-1,0},{0,1,1},{0,1,1}};
        int[][] dy = {{0,-1,-1},{0,1,1},{-1,-1,0},{1,1,0}};
        boolean removed = false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j ++){
                char check = board[i][j];
                if(check == '-')
                    continue;
                for(int k = 0; k < 4; k++){
                    boolean remove = false;
                    int[] disX = dx[k];
                    int[] disY = dy[k];

                    for(int ptr = 0; ptr < 3; ptr ++) {
                        if (validBoundary(m, n, i + disX[ptr], j + disY[ptr])
                            || check != board[i+disX[ptr]][j + disY[ptr]])
                            break;
                        if(ptr == 2) {
                            remove = true;
                            removed = true;
                        }
                    }

                    if(remove){
                        checked[i][j] = true;
                        for(int ptr = 0; ptr < 3; ptr ++) {
                            checked[i+disX[ptr]][j + disY[ptr]] = true;
                        }
                    }
                }
            }
        }
        return removed;
    }

    private boolean validBoundary(int m, int n, int x, int y){
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}

```

---
<Comment />
