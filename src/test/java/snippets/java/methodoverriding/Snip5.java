package snippets.java.methodoverriding;

class Base6 {
    public Base6() {

    }

    public void display() {
        System.out.println("Derived Variable:");
    }
}

class Derived6 extends Base6 {
    public Derived6() {
    }

    @Override
    public void display() {
        System.out.println("Derived Variable343:");
    }
}

class Snip5 {
    public static void main(String args[]) {
        Base6 baseOne = new Derived6();
        baseOne.display();
    }
}
