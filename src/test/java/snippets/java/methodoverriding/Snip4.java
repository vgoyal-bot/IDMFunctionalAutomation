package snippets.java.methodoverriding;

/**
 * Calling of a method is done based on the reference (not on the new operator.)
 * Method is present only in child class not in base class then it will throw compile time error.
 * @author vinitg
 *
 */
class Base5 {
    private int baseVar = 1000;

    public Base5() {
        baseVar++;
    }
}

class Derived5 extends Base5 {
    private int derVar;

    public Derived5(int derVar) {
        this.derVar = derVar;
    }

    public void display() {
        System.out.println("Derived Variable:" + derVar);
    }
}

class Snip4 {
    public static void main(String args[]) {
        Base5 baseOne = new Derived5(5000);
        // baseOne.display();  // uncomment this line to see this snippets work perfectly.
    }
}
