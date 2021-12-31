package boj_2290;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String n = sc.next();
        char[][] display = new char[2*s+3][(s+2)*n.length() + n.length()-1];
        for(int i = 0; i < display.length; i++){
            for(int j = 0; j < display[i].length; j++){
                display[i][j] = ' ';
            }
        }
        for(int i = 0; i < n.length(); i++){
            numberPrint(n.charAt(i)-'0',i,s,display);
        }

        for(int i = 0; i < display.length; i++){
            for(int j = 0; j < display[i].length; j++){
                System.out.print(display[i][j]);
            }
            System.out.println();
        }

    }

    public static void numberPrint(int num, int loc, int size,char[][] display){
        int x = loc*(size+3);
        int y = 0;
        if(num == 1){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,2);
        }
        else if(num ==2){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,3);
            segmentPrint(x,y,size,display,4);
            segmentPrint(x,y,size,display,5);
            segmentPrint(x,y,size,display,7);
        }else if(num == 3){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,3);
            segmentPrint(x,y,size,display,4);
            segmentPrint(x,y,size,display,5);
        }
        else if(num == 4){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,4);
            segmentPrint(x,y,size,display,6);
        }
        else if(num == 5){
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,3);
            segmentPrint(x,y,size,display,4);
            segmentPrint(x,y,size,display,5);
            segmentPrint(x,y,size,display,6);
        }
        else if(num == 6){
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,3);
            segmentPrint(x,y,size,display,4);
            segmentPrint(x,y,size,display,5);
            segmentPrint(x,y,size,display,6);
            segmentPrint(x,y,size,display,7);
        }
        else if(num == 7){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,3);
        }
        else if(num ==8){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,3);
            segmentPrint(x,y,size,display,4);
            segmentPrint(x,y,size,display,5);
            segmentPrint(x,y,size,display,6);
            segmentPrint(x,y,size,display,7);
        }
        else if(num == 9){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,3);
            segmentPrint(x,y,size,display,4);
            segmentPrint(x,y,size,display,5);
            segmentPrint(x,y,size,display,6);
        }
        else if(num == 0){
            segmentPrint(x,y,size,display,1);
            segmentPrint(x,y,size,display,2);
            segmentPrint(x,y,size,display,3);
            segmentPrint(x,y,size,display,5);
            segmentPrint(x,y,size,display,6);
            segmentPrint(x,y,size,display,7);
        }
    }

    public static void segmentPrint(int x, int y, int size, char[][] display, int segNum){
        if(segNum == 1){
            int pos = 1;
            for(int i = 0; i < size; i++) {
                display[i+pos][x + size + 1] = '|';
            }
        }
        else if(segNum == 2){
            int pos = size + 2;
            for(int i =0; i < size; i++){
                display[i+pos][x+size + 1] = '|';
            }
        }
        else if(segNum == 3){
            for(int i = 0; i < size; i++){
                display[y][i+x+1] = '-';
            }
        }
        else if(segNum == 4){
            int pos = size+1;
            for(int i = 0; i < size; i++){
                display[y+pos][i+x+1] = '-';
            }
        }
        else if(segNum == 5){
            int pos = 2*size+2;
            for(int i = 0; i <size; i++){
                display[y+pos][i+x+1] = '-';
            }
        }
        else if(segNum == 6){
            for(int i = 0; i < size; i++){
                display[y+i+1][x] = '|';
            }
        }
        else if(segNum == 7){
            int pos = size+2;
            for(int i =0 ; i < size; i++){
                display[y+i+pos][x] = '|';
            }
        }
    }
}
