package snippets.java.stringconcept;

/**
 * in the below scenarios:
 * .equals method is intelligent, it will always consider the values.
 * but == method will be confused with the object and give not equal, whereas in scenario2, it will give equal.
 * @author vinitg
 *
 */
public class StrObjectMethod {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        if (str1.equals(str2)) {
            System.out.println("str1.equals(str2) Equal");
        } else {
            System.out.println("str1.equals(str2) Not Equal");
        }
        
        Object obj1 = "Hello";
        Object obj2 = "Hello";
        
        if (obj1.equals(obj2)) {
            System.out.println("obj1.equals(obj2) Equal");
        } else {
            System.out.println("obj1.equals(obj2) Not Equal");
        }
    }
}
