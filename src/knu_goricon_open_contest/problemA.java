package knu_goricon_open_contest;

import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        String input = new Scanner(System.in).next();
        if(input.length() < 5){
            System.out.println("not cute");
            return;
        }

        String isCute = "driip";
        String back = "";

        for(int i = 1; i <= 5; i++){
            back =  input.charAt(input.length()-i) + back;
        }
        if(isCute.equals(back))
            System.out.println("cute");
        else
            System.out.println("not cute");
    }
}
