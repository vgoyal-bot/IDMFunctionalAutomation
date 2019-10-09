package snippets.java;

public class StaticClass {
	static int a = 10;
	
	public static class staticClass1{
		static int b = 20;
		public void methodInStaticClass1() {
			System.out.println("Inside method in static class 1, value of a : " +a);
		}
	}
	
	public void methodInFirstClass() {
		System.out.println("Method in First Class" +staticClass1.b);
	}
	
	public static void main(String[] args) {
		staticClass1 obj = new staticClass1();
		obj.methodInStaticClass1();
	}
}
