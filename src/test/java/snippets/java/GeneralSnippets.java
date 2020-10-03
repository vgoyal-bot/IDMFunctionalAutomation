package snippets.java;

import org.testng.annotations.Test;

public class GeneralSnippets {

	@Test
	public void convertStringToInt() {
		String str1 = "5";
		System.out.println(Integer.parseInt(str1));
	}
	
	@Test
	public void convertStringToIntGiveNumberFormatException() {
		String str1 = "ab";
		System.out.println(Integer.parseInt(str1));
	}
	
	@Test
	public void convertStringToIntGiveNumberFormatExceeption() {
		String str1 = "b";
		System.out.println(Integer.parseInt(str1));
	}

}
