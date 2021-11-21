
package problem_10757;
import java.util.Scanner;

//first try - timeout
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String A = sc.next();
//		String B = sc.next();
//		boolean rounding = false;
//		String result = "";
//		
//		if(A.length() > B.length()) {
//			for(int i = B.length(); i < A.length(); i ++) {
//				A = '0' + A;
//			}
//		}
//		else {
//			for(int i = A.length(); i < B.length(); i ++) {
//				A = '0' + A;
//			}
//		}
//		
//		for(int i = A.length()-1; i >= 0; i--) {
//			int add = Integer.parseInt(A.charAt(i)+"") + Integer.parseInt(B.charAt(i)+"");
//			if(rounding) {
//				result = String.valueOf(1 + (add%10)) + result;
//				rounding = false;
//			}
//			else
//				result = String.valueOf(add%10) + result;
//			
//			if(add > 9) {
//				add = add % 10;
//				rounding = true;
//			}
//		}
//		
//		if(rounding)
//			System.out.print(1);
//		
//		System.out.println(result);
//	}
//}


//second try - solve
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sum(sc.next(),sc.next()));	
		sc.close();
	}
	
	public static String sum(String A, String B) {
		A = reverseStr(A);
		B = reverseStr(B);
		int len = A.length() > B.length() ? B.length() : A.length();
		boolean carry = false;
		String result = "";
		
		for(int i = 0; i < len; i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			int sum = a + b;
			if(carry) {
				sum += 1;
				carry = false;
			} 
			if(sum > 9) {
				sum %= 10;
				carry = true;
			}	
			result = sum + result;
		}
		String remainder = reverseStr(A.substring(len) + B.substring(len));
		
		if(carry)
			remainder = sum(remainder,"1");
		result = remainder + result;
		return result;
	}
	
	  public static String reverseStr(String s) {
		    return (new StringBuffer(s)).reverse().toString();
		  }
}
