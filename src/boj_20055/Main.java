package boj_20055;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] durability = new int[2*n];
        for(int i =0; i< 2*n; i++){
            durability[i] = sc.nextInt();
        }

        boolean[] hasRobot = new boolean[2*n];
        int stage = 0;
        int zeroDurabilityCount = 0;
        int putPosition = 0;
        int removePosition = n;

        while(zeroDurabilityCount != k){
            // 한칸 회전
            putPosition = (putPosition-1+(2*n))%(2*n);
            removePosition = (removePosition-1+(2*n))%(2*n);
            if(hasRobot[removePosition])
                hasRobot[removePosition] = false;

            //로봇 한칸 이동
            for(int i = 0; i <= n; i++){
                int pos = (removePosition-i+2*n)%(2*n);
                if(hasRobot[pos]){
                    if(hasRobot[(pos+1)%(2*n)]) continue;
                    if(durability[(pos+1)%(2*n)] == 0) continue;

                    hasRobot[pos] = false;
                    hasRobot[(pos+1)%(2*n)] = true;
                    durability[(pos+1)%(2*n)] -=1;
                    if(durability[(pos+1)%(2*n)] == 0){
                        zeroDurabilityCount += 1;
                    }
                }
            }
            if(hasRobot[removePosition])
                hasRobot[removePosition] = false;

            //로봇 올리기
            if(durability[putPosition] != 0){
                hasRobot[putPosition] = true;
                durability[putPosition] -= 1;
                if(durability[putPosition] == 0){
                    zeroDurabilityCount += 1;
                }
            }
            stage++;
        }

        System.out.println(stage);
    }
}
