package snippets.java.methodoverriding;

public class ParentClassPoly {

    public void scenario1() {
        System.out.println("only in Parent Class");
    }
    
    public void scenario3() {
        System.out.println("both in parent and child override, but parent method called");
    }

    public void scenario4() {
        System.out.println("both in parent and child, but not override, but parent method called");
    }
    
    public void scenario5() {
        System.out.println("present in parent only");
    }
}
