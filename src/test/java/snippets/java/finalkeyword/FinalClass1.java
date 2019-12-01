package snippets.java.finalkeyword;

/**
 * We can have private static and final keyword together for a variable.
 * final- is used to keep the value constant.
 * static : is used so that it can be used inside static methods.
 * But why private is used as when we are keeping the variable as final, it will be available only
 * to that class.:
 * because we are keeping it as private, so other class cant use it.
 * @author vinitg
 *
 */
public class FinalClass1 {
    private static final int a = 10;

    public static void main(String[] args) {
        System.out.println("int a: " + a);
    }
}
