package level1_problem_12947;

public class Solution {
    public boolean solution(int x) {
        int x_val = x;
        int sum = 0;
        while(x_val != 0){
            sum += x_val%10;
            x_val = x_val/10;
        }
        return x % sum == 0;
    }
}