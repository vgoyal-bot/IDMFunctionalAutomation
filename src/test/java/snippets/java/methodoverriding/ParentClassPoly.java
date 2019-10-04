package snippets.java.methodoverriding;

public class ParentClassPoly {

    public void display() {
        System.out.println("Parent Class + noArgument");
    }

    public void display(int a) {
        System.out.println("Parent Class + one int argument");
    }

    public void display(String a) {
        System.out.println("Parent Class + one string argument");
    }
}
