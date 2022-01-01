package boj_1917;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problemCount =3;

        while (problemCount-- > 0){
            int[][] dev = new int[6][6];

            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 6; j++){
                    dev[i][j] = sc.nextInt();
                }
            }
        }
    }
}
