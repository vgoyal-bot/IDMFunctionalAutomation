package snippets.java;

public class InnerClass {
	int a = 10;
	
	public class InnerClass1 {
		int b= 20;
		public void methodInInnerClass1() {
			System.out.println("inside inner class, a: " +a);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClass objInnerClass = new InnerClass();
		InnerClass1 obj1 = objInnerClass.new InnerClass1();
		obj1.methodInInnerClass1();
		
		try {
			System.out.println();
		}catch(Exception e) {
			
		}
	}
}


