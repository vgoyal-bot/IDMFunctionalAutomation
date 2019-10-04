package snippets.java.string;

public class Str1 {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        if (str1 == str2) {
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

        if (str3 == str4) {
            System.out.println("str3 == str4 Equal");
        } else {
            System.out.println("str4 == str4 Not Equal");
        }

        if (str3.equals(str4)) {
            System.out.println("str3.equals(str4) Equal");
        } else {
            System.out.println("str3.equals(str4) Not Equal");
        }
    }
}
