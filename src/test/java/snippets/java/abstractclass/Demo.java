package snippets.java.abstractclass;

abstract class Example {
    void disp() {
        System.out.println("disp in Example");
    }

    public abstract void display();
}

abstract class Example1 extends Example {
    public void display1() {
        System.out.println("display in Example1");
    }
}

class Example2 extends Example1 {
    @Override
    public void display() {
        System.out.println("display in Example2");
    }
}

class Demo {
    public static void main(String args[]) {
        Example2 obj = new Example2();
        obj.display();
    }
}
