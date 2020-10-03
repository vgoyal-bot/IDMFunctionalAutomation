package snippets.java.stringconcept;

/**
 * in the below scenarios:
 * .equals method is intelligent, it will always consider the values.
 * but == method will be confused with the object and give not equal, whereas in scenario2, it will give equal.
 * @author vinitg
 *
 */
public class Str1 {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        if (str1 == str2) {				// scenario1
            System.out.println("str1 == str2 Equal");
        } else {
            System.out.println("str1 == str2 Not Equal");
        }

        if (str1.equals(str2)) {
            System.out.println("str1.equals(str2) Equal");
        } else {
            System.out.println("str1.equals(str2) Not Equal");
        }

        String str3 = "Hello";
        String str4 = "Hello";

        if (str3 == str4) {					// scenario 2
            System.out.println("str3 == str4 Equal");
        } else {
            System.out.println("str4 == str4 Not Equal");
        }

        if (str3.equals(str4)) {
            System.out.println("str3.equals(str4) Equal");
        } else {
            System.out.println("str3.equals(str4) Not Equal");
        }
        
        String str5 = new String("Hello");
        String str6 = "Hello";
        
        if (str5 == str6) {					// scenario 3
            System.out.println("str5 == str6 Equal");
        } else {
            System.out.println("str5 == str6 Not Equal");
        }

        if (str5.equals(str6)) {
            System.out.println("str5.equals(str6) Equal");
        } else {
            System.out.println("str5.equals(str6) Not Equal");
        }

    }
}
