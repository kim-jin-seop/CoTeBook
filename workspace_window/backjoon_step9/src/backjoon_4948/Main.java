package backjoon_4948;

import java.util.Scanner;

/*베르트랑 공준
 * 임의의 자연수 n에 대하여 n보다 크고 2n보다 작거나 같은 소수는 적어도 하나 존재함
 * 입력 : n
 * 출력 : n보다 크고 2n보다 작거나 같은 소수의 개수 
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		while((n = sc.nextInt()) != 0) {
			int Count = 0;
			for(int i = n+1; i <= 2*n; i++){
				int j;
				boolean isPrime = true;
				for(j = 2; j*j <= i; j ++) {
					if(i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if(i != 1 && isPrime)
					Count ++;
			}
			System.out.println(Count);
		}
	}
}
