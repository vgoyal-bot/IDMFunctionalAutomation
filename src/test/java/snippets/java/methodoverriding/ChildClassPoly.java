package snippets.java.methodoverriding;

public class ChildClassPoly extends ParentClassPoly {

    @Override
    public void display() {
        System.out.println("Child Class + noArgument");
    }

    @Override
    public void display(int a) {
        System.out.println("Child Class + one int argument");
    }

    public void display(char a) {
        System.out.println("Child Class + one char argument");
    }
}
