package pgm_64065;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public Integer[] solution(String s) {
        s = s.substring(1,s.length()-1);
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            String value = "";
            if(s.charAt(i) == '{'){
                while (s.charAt(++i) != '}'){
                    value =  value + s.charAt(i);
                }
                list.add(value);
            }
        }

        String[] values = list.toArray(new String[0]);
        Arrays.sort(values,(o1,o2) -> o1.length() > o2.length() ? 1 : -1);

        ArrayList<Integer> tuple = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(String value : values){
            String[] splitValue = value.split(",");

            for(String v : splitValue){
                if(!set.contains(Integer.parseInt(v))){
                    tuple.add(Integer.parseInt(v));
                    set.add(Integer.parseInt(v));
                }
            }
        }
        return tuple.toArray(new Integer[0]);
    }
}
