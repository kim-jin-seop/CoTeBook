package algoSpot_Festival_Session1;

//브루트포스 알고리즘 사용
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        for (int testCase = 0; testCase < C; testCase++) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            int[] cost = new int[N];
            for (int i = 0; i < cost.length; i++)
                cost[i] = sc.nextInt();

            double min = Integer.MAX_VALUE;
            int minCount = L;
            int count = L;

            while(count <= N) {
                for (int left = 0; left + count <= N; left++) {
                    double sum = 0;
                    for (int i = 0; i < count; i++) {
                        sum += cost[left + i];
                    }
                    if (sum/count < min/minCount) {
                        min = sum;
                        minCount = count;
                    }
                }
                count++;
            }
            System.out.println(min*1.0/minCount);
        }
    }
}
