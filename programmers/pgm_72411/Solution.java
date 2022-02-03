package pgm_72411;

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < course.length; i++){
            Map<String, Integer> menu = new HashMap<>();
            for(int j = 0; j < orders.length; j++){
                boolean[] check = new boolean[orders[j].length()];

                String order = orders[j];
                char[] temp = new char[order.length()];
                for(int idx = 0; idx < temp.length; idx++)
                    temp[idx] = order.charAt(idx);
                Arrays.sort(temp);

                order = "";
                for(char c : temp){
                    order = order + c;
                }

                selectMenu(course[i],0,0,order,check,menu);
            }

            Integer[] values = menu.values().toArray(new Integer[0]);
            int max = Integer.MIN_VALUE;
            for(int val : values){
                if(val > max)
                    max = val;
            }

            if(max > 1) {
                String[] keys = menu.keySet().toArray(new String[0]);
                for (String key : keys) {
                    if (menu.get(key) == max)
                        answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public void selectMenu(int menuCount, int selectedMenuCount, int start, String order,boolean[] check,Map<String, Integer> menu){
        if(selectedMenuCount == menuCount){
            String result = "";
            for(int i = 0; i < check.length; i++){
                if(check[i])
                    result = result + order.charAt(i);
            }
            if(menu.containsKey(result)){
                int cnt = menu.get(result) + 1;
                menu.put(result,cnt);
            }
            else
                menu.put(result,1);
            return;
        }

        for(int i = start; i < order.length(); i++){
            check[i] = true;
            selectMenu(menuCount,selectedMenuCount+1,i+1,order,check,menu);
            check[i] = false;
        }

    }
}