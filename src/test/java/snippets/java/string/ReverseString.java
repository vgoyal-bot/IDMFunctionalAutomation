package snippets.java.string;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello";
		String reverStr="";
		int length = str.length();
		for(int i=length-1;i>=0;i--) {
			reverStr = reverStr + str.charAt(i);
		}
		System.out.println(reverStr);
	}

}
