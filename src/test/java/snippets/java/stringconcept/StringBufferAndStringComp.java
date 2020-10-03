package snippets.java.stringconcept;

import org.testng.annotations.Test;

public class StringBufferAndStringComp {
	
	@Test
	public void test1() {
		String s1 = "Hello";
		System.out.println(s1.hashCode());
		s1 = s1+"vinit";
		System.out.println(s1.hashCode());
		
		StringBuffer sb1 = new StringBuffer("Hello2");
		System.out.println(sb1.hashCode());
		sb1 = sb1.append("Vinit2");
		System.out.println(sb1.hashCode());
		
		String str1 = new String("Hello1");
		System.out.println(str1.hashCode());
		str1 = str1.concat("vinit1");
		System.out.println(str1.hashCode());
	}
	
	// this testcase checks the performance of both Strings, String Buffer and String Builder
    @Test
	public void performanceTest() { 
        long startTime = System.currentTimeMillis();  
        StringBuffer sb = new StringBuffer("Java");  
        for (int i=0; i<100000; i++){  
            sb.append("Tpoint");  
        }  
        System.out.println("Time taken by StringBuffer for 100000 concat: " + (System.currentTimeMillis() - startTime) + "ms");  
        
        startTime = System.currentTimeMillis();  
        StringBuilder sb2 = new StringBuilder("Java");  
        for (int i=0; i<100000; i++){  
            sb2.append("Tpoint");  
        }  
        System.out.println("Time taken by StringBuilder for 100000 concat: " + (System.currentTimeMillis() - startTime) + "ms");
        
        startTime = System.currentTimeMillis();  
        String s1 = new String("Java");  
        for (int i=0; i<100000; i++){  
            s1.concat("Tpoint");  
        }  
        System.out.println("Time taken by String1 for 100000 concat: " + (System.currentTimeMillis() - startTime) + "ms");
        
        startTime = System.currentTimeMillis();  
        String s2 = "Java";  
        for (int i=0; i<10000; i++){  
            s2 = s2 + "Tpoint";  
        }  
        System.out.println("Time taken by String2 for 10000 concat: " + (System.currentTimeMillis() - startTime) + "ms"); 
    }  
}
