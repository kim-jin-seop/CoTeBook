package pgm_12985;

public class Solution {
    public int solution(int n, int a, int b)
    {
        return recursiveSolve(1,n,a,b);
    }

    public int recursiveSolve(int startNumber, int finishNumber, int playerA, int playerB){
        //둘 다 같은 위치에 포함 될 때
        if(inPlayer(startNumber,finishNumber,playerA) && inPlayer(startNumber,finishNumber,playerB)) {
            int partition = startNumber + (finishNumber - startNumber + 1)/2;
            int left = recursiveSolve(startNumber,  partition-1 , playerA, playerB);
            int right = recursiveSolve(partition,finishNumber,playerA,playerB);
            return left == -1 ? right : left;
        }
        //둘 다 포함되어있지 않을 때
        else if(!inPlayer(startNumber,finishNumber,playerA) && !inPlayer(startNumber,finishNumber,playerB))
            return -1;
        else{
            //다른 토너먼트로 포함되어있을 때
            int count = (finishNumber - startNumber + 1);
            int result = 0;

            //토너먼트 진행 횟수 계산
            while (count != 0){
                count /=2;
                result++;
            }
            return result;
        }
    }

    //구역에 플레이어가 존재하는지 확인
    public boolean inPlayer(int startNumber, int finishNumber, int player){
        return player >= startNumber && player <= finishNumber;
    }
}