package backjoon_15596;

// https://www.acmicpc.net/problem/15596
public class Test {
	public long sum(int[] a) {
		long result = 0;
		for(int i =0; i < a.length; i ++) {
			result += a[i];
		}
		return result;
	}
}
