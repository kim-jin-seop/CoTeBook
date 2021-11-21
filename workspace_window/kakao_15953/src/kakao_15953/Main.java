package kakao_15953;

import java.util.Scanner;

public class Main {
    final static int a_1 = 5000000;
    final static int a_2 = 3000000;
    final static int a_3 = 2000000;
    final static int a_4 = 500000;
    final static int a_5 = 300000;
    final static int a_6 = 100000;

    final static int b_1 = 5120000;
    final static int b_2 = 2560000;
    final static int b_3 = 1280000;
    final static int b_4 = 640000;
    final static int b_5 = 320000;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++){
            cal(sc.nextInt(),sc.nextInt());
        }
    }

    public static void cal(int a, int b){
        int a_reword = 0;
        int b_reword = 0;

        if(a != 0 && a < 22) {
            for (int i = 1; i < 7; i++) {
                a = a-i;
                if(a <= 0){
                    a_reword = reword(true,i);
                    break;
                }
            }
        }
        if(b != 0 && b < 32){
            int member = 1;
            for (int i = 1; i < 6; i++) {
                b = b-member;
                if(b <= 0){
                    b_reword = reword(false,i);
                    break;
                }
                member = member*2;
            }
        }
        System.out.println(a_reword + b_reword);
    }

    public static int reword(boolean first, int rank){
        if(first){
            switch(rank){
                case 1:
                    return a_1;
                case 2:
                    return a_2;
                case 3:
                    return a_3;
                case 4:
                    return a_4;
                case 5:
                    return a_5;
                default:
                    return a_6;
            }
        }
        else{
            switch(rank){
                case 1:
                    return b_1;
                case 2:
                    return b_2;
                case 3:
                    return b_3;
                case 4:
                    return b_4;
                default:
                    return b_5;
            }
        }
    }
}

