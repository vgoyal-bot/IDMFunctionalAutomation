package snippets.java;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class LoopsNSwitchCase {
	
	@Test
	public void forloop() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
	}
	
	@Test
	public void foreach() {
		List<String> listStr = new ArrayList<String>();
		listStr.add("a");
		listStr.add("b");
		listStr.add("c");
		
		for(String str: listStr) {
			System.out.println(str);
		}
	}
	
	@Test
	public void whileloop1() {
		int i=0;
		while(i<10) {
			System.out.println(i++);
		}
	}
	
	@Test
	public void whileloop2() {
		int i=0;
		while(i<10) {
			System.out.println(++i);
		}
	}
	
	@Test
	public void doWhile() {
		int i=0;
		do {
			System.out.println(i++);
		}while(i<10);
	}
	
	@Test
	public void switchcase() {
		String str = "sunday";
		
		switch(str) {
		case "monday" :
			System.out.println("inside monday");
			break;
			
		case "sunday" :
			System.out.println("inside sunday");
			break;
			
		default:
			System.out.println("inside default");
		}
	}
}
