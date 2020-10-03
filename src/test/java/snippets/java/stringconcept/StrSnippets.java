package snippets.java.stringconcept;

import org.testng.annotations.Test;

public class StrSnippets {

	// Input : java
	// output : Java
	@Test
	public void convertToUpperCase0() {
		String str1 = "java";
		String str2 = str1.substring(0, 1).toUpperCase() + str1.substring(1);
		System.out.println("str2:" + str2);
	}
		
	// Input : this is vinitgoyal
	// Output : This Is Vinitgoyal
	@Test
	public void convertToUpperCase() {
		String str1= "this is vinitgoyal";
		String str2 = str1.substring(0,1).toUpperCase() + str1.substring(1);

		for(int i=0; i<str1.length(); i ++) {
			if(str1.charAt(i) == ' ') {
				str2 = str2.substring(0,i+1) + str2.substring(i+1, i+2).toUpperCase() + str2.substring(i+2);
			}
		}
		System.out.println("str2:" + str2);
	}
	
	// Input : this is vinit
	// Output tiniv si siht
	@Test
	public void reverseEachChar() {
		String str1 = "this is vinit";
		String str2 = "";
		for(int i = str1.length()-1; i>=0; i--) {
			str2 = str2 + str1.charAt(i);
		}
		System.out.println("str2: " +str2);
	}
	
	// Input : this is vinit
	// Output siht si tiniv
	@Test
	public void reverseEachCharIndependently() {
		String str1 = "this is vinit";
		String str2 = "";
		int tempSpacePos = -1;
		String[] strArr = str1.split(" ");
		String[] strArr1 = new String[strArr.length];
		
		for(int i=0; i<strArr.length; i++) {
			String tempStr = strArr[i];
			String tempStr1 = "";
			for(int j=tempStr.length()-1; j>=0; j--) {
				tempStr1 = tempStr1 + tempStr.charAt(j);
			}
			strArr1[i] = tempStr1;
		}
		
		System.out.println("new string arr: " + strArr1[0]);
		System.out.println("new string arr: " + strArr1[1]);
		System.out.println("new string arr: " + strArr1[2]);
		
		for(int i=0; i<strArr1.length; i++) {
			str2 = str2 + " " + strArr1[i];
		}
		System.out.println("str2: " +str2.trim());
	}
	
	@Test
	public void palindrome() {
		String str1 = "geeg";
		int flag=0;
		int n = str1.length();
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i) != str1.charAt(n-i-1) && i <=n-i-1) {
				flag=1;
				break;
			}
		}
		
		if(flag ==1 ) {
			System.out.println("not palindrome");
		}else {
			System.out.println("palindrome");
		}
	}
	
	/**
	 * Input : ab@b#nj@
	 * Outut : jn@b#ba@
	 */
	@Test
	public void palindrome1() {
		String str1 = "ab@b#nj@";
		
	}
}