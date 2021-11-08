package backjoon_11723;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            String[] lines = br.readLine().split(" ");
            if(lines[0].equals("add"))
                add(set,Integer.parseInt(lines[1]));
            else if(lines[0].equals("remove"))
                remove(set,Integer.parseInt(lines[1]));
            else if(lines[0].equals("check")) {
                bw.write(check(set, Integer.parseInt(lines[1])));
                bw.newLine();
            }
            else if(lines[0].equals("toggle"))
                toggle(set,Integer.parseInt(lines[1]));
            else if(lines[0].equals("all"))
                all(set);
            else if(lines[0].equals("empty"))
                empty(set);
        }
        bw.flush();
    }

    public static void add(Set<Integer> set, int num){
        set.add(num);
    }
    public static void remove(Set<Integer> set, int num){
        set.remove(num);
    }

    public static String check(Set<Integer> set, int num){
        return set.contains(num) ? "1" : "0";
    }

    public static void toggle(Set<Integer> set, int num){
        if(set.contains(num))
            set.remove(num);
        else
            set.add(num);
    }
    public static void all(Set<Integer> set){
        for(int i = 1;i<=20; i++){
            set.add(i);
        }
    }
    public static void empty(Set<Integer> set){
        set.clear();
    }
}
