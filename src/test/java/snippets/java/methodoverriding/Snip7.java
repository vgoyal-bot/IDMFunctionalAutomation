package snippets.java.methodoverriding;

/**
 * Calling of a method is done based on the reference (not on the new operator.)
 * In this case, disp() method must be present in base class. As it will search for method in base class.
 * If method is present only in base class(not in child class), then it means it will call method of base class.
 * @author vinitg
 *
 */
class BaseClasss {
    public void disp() {
        System.out.println("BaseClasss: disp");
    }
}

class Snip7 extends BaseClasss {
    public static void main(String[] args) {
        BaseClasss obj = new Snip7();
        obj.disp();
    }
}