package backjoon_2941;
// https://www.acmicpc.net/status?user_id=tjq2702&problem_id=2941&from_mine=1
/*문제이해
 * 크로아티아 알파벳을 포함하여 문자의 수 계산
 * */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println(input.length()-croatiaCount(input));
	}
	
	public static int croatiaCount(String data) {
		int count = 0;
		while(true) {
			int index = 0;
			if((index = data.indexOf("dz=")) >= 0) {
				data = data.substring(0,index) +" " +data.substring(index+3,data.length());
				count += 2;
			}
			else if((index = data.indexOf("c="))>= 0) {
				data = data.substring(0,index) +" " + data.substring(index+2,data.length());
				count += 1;
			}
			else if((index = data.indexOf("c-"))>= 0) {
				data = data.substring(0,index) +" " + data.substring(index+2,data.length());
				count += 1;
			}
			else if((index = data.indexOf("d-"))>= 0) {
				data = data.substring(0,index) +" " + data.substring(index+2,data.length());
				count += 1;
			}
			else if((index = data.indexOf("lj"))>= 0) {
				data = data.substring(0,index) +" " + data.substring(index+2,data.length());
				count += 1;
			}
			else if((index = data.indexOf("nj"))>= 0) {
				data = data.substring(0,index) +" " + data.substring(index+2,data.length());
				count += 1;
			}
			else if((index = data.indexOf("s="))>= 0) {
				data = data.substring(0,index) +" " + data.substring(index+2,data.length());
				count += 1;
			}
			else if((index = data.indexOf("z="))>= 0) {
				data = data.substring(0,index) +" " +data.substring(index+2,data.length());
				count += 1;
			}
			else {
				break;
			}
		}
		return count;
	}
}
