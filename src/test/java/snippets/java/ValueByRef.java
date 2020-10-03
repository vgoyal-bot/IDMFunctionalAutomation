package snippets.java;

public class ValueByRef {

	/*
	 * This code depicts that the value does not change
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10;
		System.out.println("before calling : " + a);
		
		valueByRef(a);
		System.out.println("after calling : " + a);
	}

	static void valueByRef(int a)
	{
		a = 20;
	}
}
