package knu_goricon_open_contest;

import java.util.*;

public class problemC {
    public static void main(String[] args) {
        Map<Integer, String> intToStrMap = new HashMap<>();
        Map<String,Integer> strToIntMap = new HashMap<>();
        Stack<String> calculrator = new Stack<>();
        intToStrMapping(intToStrMap);
        strToIntMapping(strToIntMap);

        String wrongAns = "Madness!";
        String input = new Scanner(System.in).next();

        String value = "";
        String sentence = "";
        for(int i = 0; i< input.length(); i++){
            value = value + input.charAt(i);
            if(value.equals("+") || value.equals("-") || value.equals("x") || value.equals("/")){
                calculrator.add(value);
                sentence += value;
                value = "";
            }

            if(strToIntMap.containsKey(value)){
                int mappingValue = strToIntMap.get(value);
                sentence += mappingValue;
                calculrator.add(String.valueOf(mappingValue));
                value = "";
            }

            if(value.length() > 5){
                System.out.println(wrongAns);
                return;
            }
        }

        if(!value.matches("^[=]*$")){
            System.out.println(wrongAns);
            return;
        }

        Stack<String> stack = new Stack<>();
        while(!calculrator.isEmpty()){
            stack.add(calculrator.pop());
        }


        String prevOper ="";
        while(!stack.isEmpty()){
            if(stack.size() == 1){
                break;
            }
            String popValue = stack.pop();
            if(popValue.equals("+") || popValue.equals("-") || popValue.equals("x") || popValue.equals("/")){
                if(prevOper.equals("")){
                    prevOper += popValue;
                    continue;
                }
                long returnValue = solve(stack, prevOper, popValue);
                stack.add(String.valueOf(returnValue));
                prevOper ="";
            }
            else {
                prevOper += popValue;
            }
        }

        String result = stack.pop();
        String answer = "";
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) == '-')
                answer += "-";
            else{
                answer += intToStrMap.get(Integer.valueOf(result.charAt(i)-'0'));
            }
        }
        System.out.println(sentence + "=");
        System.out.println(answer);
    }

    private static Long solve(Stack<String> stack, String oper_prev ,String operator) {
        String oper_next = "";
        while(!stack.isEmpty()){
            String popValue = stack.pop();
            if(popValue.equals("+") || popValue.equals("-") || popValue.equals("x") || popValue.equals("/")){
                stack.add(popValue);
                break;
            }
            oper_next += popValue;
        }

        if(operator.equals("+"))
            return Long.valueOf(oper_prev) + Long.valueOf(oper_next);
        else if(operator.equals("-"))
            return Long.valueOf(oper_prev) - Long.valueOf(oper_next);
        else if(operator.equals("x"))
            return Long.valueOf(oper_prev) * Long.valueOf(oper_next);
        else {
            return Long.valueOf(oper_prev) / Long.valueOf(oper_next);
        }

    }

    private static void strToIntMapping(Map<String, Integer> map) {
        map.put("ZERO",0);
        map.put("ONE",1);
        map.put("TWO",2);
        map.put("THREE",3);
        map.put("FOUR",4);
        map.put("FIVE",5);
        map.put("SIX",6);
        map.put("SEVEN",7);
        map.put("EIGHT",8);
        map.put("NINE",9);
    }

    private static void intToStrMapping(Map<Integer, String> map) {
        map.put(0,"ZERO");
        map.put(1,"ONE");
        map.put(2,"TWO");
        map.put(3,"THREE");
        map.put(4,"FOUR");
        map.put(5,"FIVE");
        map.put(6,"SIX");
        map.put(7,"SEVEN");
        map.put(8,"EIGHT");
        map.put(9,"NINE");
    }
}
