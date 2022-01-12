package boj_4574;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int puzzleCount = 1;
        while((n = sc.nextInt()) != 0){
            int[][] board = new int[9][9];
            Map<String, Boolean> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                int num1 = sc.nextInt();
                String location1 = sc.next();
                board[location1.charAt(0)-'A'][location1.charAt(1)-'1'] = num1;

                int num2 = sc.nextInt();
                String location2 = sc.next();
                board[location2.charAt(0)-'A'][location2.charAt(1)-'1'] = num2;
                map.put(Math.min(num1,num2) + "" +Math.max(num1,num2),true);
            }
            for(int i = 1; i <10; i++){
                String location = sc.next();
                board[location.charAt(0)-'A'][location.charAt(1)-'1'] = i;
            }
            solve(board,map,0,0);


            System.out.println("Puzzle " + puzzleCount++);
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static boolean solve(int[][] board, Map<String,Boolean> map,int x, int y){
        if(x == 9){
            return true;
        }
        if(board[x][y] != 0){
            return solve(board,map,y+1 == 9 ? x+1 : x,(y+1)%9);
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        ArrayList<Integer> checkArr = checkInputValue(board, x, y);
        if(checkArr.size() == 0)
            return false;
        for(int i = 0; i < checkArr.size(); i++){
            int inputValue = checkArr.get(i);
            board[x][y] = inputValue;
            for(int idx = 0; idx < 4; idx++){
                int nextX = x+dx[idx];
                int nextY = y+dy[idx];
                if(nextX < 0 || nextX > 8 || nextY < 0 || nextY > 8)
                    continue;
                if(board[nextX][nextY] != 0)
                    continue;

                ArrayList<Integer> nextCheckArr = checkInputValue(board, nextX, nextY);
                if(nextCheckArr.size() == 0)
                    break;
                for(int j = 0; j < nextCheckArr.size(); j++){
                    int inputNext = nextCheckArr.get(j);
                    String key = Math.min(inputNext,inputValue) + "" +Math.max(inputNext,inputValue);
                    if(map.containsKey(key)){
                        continue;
                    }
                    map.put(key,true);
                    board[nextX][nextY] = inputNext;
                    if(solve(board,map,y+1 == 9 ? x+1 : x,(y+1)%9))
                        return true;
                    board[nextX][nextY] = 0;
                    map.remove(key);
                }
            }
            board[x][y] = 0;
        }
        return false;
    }

    // 해당 칸에 삽입이 가능한 값들을 모아서 ArrayList에 넣어서 반환
    private static ArrayList<Integer> checkInputValue(int[][] board, int x, int y) {
        ArrayList<Integer> checkArr = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            int j;

            for(j = 0; j < board.length; j++){
                if(board[j][y] == i || board[x][j] == i){
                    break;
                }
            }
            if(j == board.length){
                int xShare = x /3;
                int yShare = y /3;
                boolean isOk = true;
                for(int xIdx = 0; xIdx < 3; xIdx ++){
                    for(int yIdx = 0; yIdx < 3; yIdx++){
                        if(board[xShare*3 + xIdx][yShare*3 + yIdx] == i)
                            isOk = false;
                    }
                }
                if(isOk){
                    checkArr.add(i);
                }
            }
        }
        return checkArr;
    }
}
