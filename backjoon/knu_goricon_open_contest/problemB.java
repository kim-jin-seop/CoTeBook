package knu_goricon_open_contest;

import java.util.Scanner;

public class problemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startY = sc.nextInt();
        int startM = sc.nextInt();
        int startD = sc.nextInt();

        int wantY = sc.nextInt();
        int wantM = sc.nextInt();
        int wantD = sc.nextInt();

        int gapY = wantY - startY;
        int gapM = wantM - startM;
        int gapD = wantD - startD;

        if(gapD < 0) {
            gapM -= 1;
            gapD += 30;
        }
        if(gapM < 0){
            gapY -= 1;
            gapM += 12;
        }
        if(gapY < 0){
            System.out.println("0 0\n0days");
            return;
        }

        int yearly = 0;
        for(int i = 0; i < gapY; i++){
            yearly += 15 + i/2;
        }

        gapM += gapY*12;
        int monthly = Math.min(gapM,36);

        int daily = gapD + gapM*30;

        System.out.println(yearly + " " + monthly);
        System.out.println(daily == 1 ? "days" : daily + "days");
    }

}
