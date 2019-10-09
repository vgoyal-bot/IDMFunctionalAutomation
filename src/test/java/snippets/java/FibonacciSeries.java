package snippets.java;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {
	public static void main(String[] args) {
		List<Integer> fibonacciList = new ArrayList<Integer>();
		int a = 0;
		int b = 1;
		int c = 1;
		fibonacciList.add(a);
		fibonacciList.add(b);

		for(int i=1;i<=10;i++) {
			c=a+b;
			fibonacciList.add(c);
			a=b;
			b=c;
		}
		System.out.println(fibonacciList);
	}
}
