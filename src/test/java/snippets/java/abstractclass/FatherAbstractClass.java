package snippets.java.abstractclass;

public abstract class FatherAbstractClass extends GrandFatherAbstractClass {

    @Override
    public abstract void grandFatherAbstractMethod1();

    @Override
    public void grandFatherAbstractMethod2() {
        System.out.println("Inside grandFatherAbstractMethod2 in FatherAbstractClass");
        String str[] = new String[3];
    }
}
