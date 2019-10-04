package snippets.java.methodoverriding;

/**
 * Static method in the base class can be redefined in the derived class

 * If you try to override a static method, you  don’t get the same effect as that for the non-static method.
 * It is considered as static method of the derived class.

 * @author vinitg
 *
 */
class BaseClass {
    public static void staticMethod() {
        System.out.println("BaseClass:  staticMethod");
    }

    public void disp() {
        System.out.println("BaseClass: disp");
    }
}

class Snip6 extends BaseClass {
    public static void staticMethod() {
        System.out.println("Derived Class: staticMethod");
    }

    @Override
    public void disp() {
        System.out.println("Derived Class: disp");
    }

    public static void main(String[] args) {
        BaseClass obj = new Snip6();
        obj.staticMethod();
        obj.disp();
    }
}