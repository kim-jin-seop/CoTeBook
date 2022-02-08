package pgm_17677;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public  int solution(String str1, String str2) {
        Map<String, Integer> first = makeMultiSet(str1);
        Map<String, Integer> second = makeMultiSet(str2);
        if(first.size() == 0 && second.size() == 0)
            return 65536;

        Set<String> firstKeySet = first.keySet();
        Set<String> secondKeySet = second.keySet();

        int intersection = 0;
        for(String key : firstKeySet){
            if(!second.containsKey(key))
                continue;
            intersection += Math.min(first.get(key),second.get(key));
        }

        int union = -1 * intersection;
        for(String key : firstKeySet){
            union += first.get(key);
        }
        for(String key : secondKeySet){
            union += second.get(key);
        }

        return (int)((intersection/(union*1.0))*65536);
    }
    public Map<String, Integer> makeMultiSet(String str){
        Map<String, Integer> multiSet = new HashMap<>();
        for(int i = 0; i < str.length()-1; i++){
            if(!Character.isAlphabetic(str.charAt(i)) || !Character.isAlphabetic(str.charAt(i+1)))
                continue;

            String key = String.valueOf(Character.toLowerCase(str.charAt(i))) + String.valueOf(Character.toLowerCase(str.charAt(i+1)));
            int value = 0;
            if(multiSet.containsKey(key)){
                value = multiSet.get(key);
            }
            multiSet.put(key,value+1);
        }

        return multiSet;
    }

}