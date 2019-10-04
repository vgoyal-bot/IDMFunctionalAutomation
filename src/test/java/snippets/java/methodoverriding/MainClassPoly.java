package snippets.java.methodoverriding;

public class MainClassPoly {
    public MainClassPoly(int a) {

    }

    public static void main(String[] args) {

        System.out.println("---------------------1-------------------- ");
        ChildClassPoly childClassObj = new ChildClassPoly();
        childClassObj.display();

        System.out.println("---------------------2-------------------- ");
        ParentClassPoly parentClassObj = new ParentClassPoly();
        parentClassObj.display();

        System.out.println("---------------------3-------------------- ");
        ParentClassPoly parentChildObj = new ChildClassPoly(); // this is example of method over riding.
        parentChildObj.display();

        System.out.println("---------------------4-------------------- ");

        ParentClassPoly objParent = new ParentClassPoly();
        ChildClassPoly objChild = new ChildClassPoly();

        objChild.display(10);

        System.out.println("---------------------5-------------------- ");
        objParent.display(10);

        System.out.println("---------------------6-------------------- ");
        objChild.display("");

        System.out.println("---------------------7-------------------- ");
        objChild.display('a');

        System.out.println("---------------------8-------------------- ");
        ParentClassPoly objParentChild = new ChildClassPoly();
        objParentChild.display(10);
    }
}
