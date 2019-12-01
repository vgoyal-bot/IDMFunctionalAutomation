package snippets.java.methodoverriding;

/**
 * there are different scenarioasL\:
 * 1. scenario 1 : method present in only parent class, called in main class. by parent class obj.
 * 2. scenario 2 : method present in child class called by child class method.
 * 3. scenario 3 : method present in both parent and child with override
 * 4. scenario 4 : method present in both parent and child but not override
 * 5. scenario5 : presnet in parent only, but called by over ride obj.
 * 
 * @author vinitg
 *
 */
public class MainClassPoly {
    public static void main(String[] args) {


        ParentClassPoly parentClassObj = new ParentClassPoly(); // scenario1
        parentClassObj.scenario1();

        ChildClassPoly childClassObj = new ChildClassPoly(); 	// scenario2
        childClassObj.scenario2();
        
        ParentClassPoly parentChildObj = new ChildClassPoly(); // scenario3 and scenario4
        parentChildObj.scenario3();
        parentChildObj.scenario4();
        parentChildObj.scenario5();
    }   
}