package snippets.java.methodoverriding;

import java.io.IOError;
import java.io.IOException;

public class ChildClassPoly extends ParentClassPoly {

    public void scenario2() {
        System.out.println("only in child Class");
    }
    
    @Override
    public void scenario3() {
        System.out.println("both in parent and child override, but child method called");
    }
    
    public void scenario4() {
        System.out.println("both in parent and child, but not override, but child method called");
    }
}
