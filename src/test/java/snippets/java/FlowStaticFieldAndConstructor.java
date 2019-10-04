package snippets.java;

/**
 * Irrespective of the position of the static block. Once the class gets loaded
 * initially static block will run, then everything else will run in sequence.
 *
 * @author evingoy
 *
 */
public class FlowStaticFieldAndConstructor {
    public FlowStaticFieldAndConstructor() {
        System.out.println("Inside Constructor");
    }

    private static String var = "static variable";

    public static void main(String[] args) {
        FlowStaticFieldAndConstructor obj = new FlowStaticFieldAndConstructor();
        System.out.println("Inside static method");
        System.out.println("var : " + var);
    }

    static {
        System.out.println("Inside static block");
    }

}