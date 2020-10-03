package snippets.java.methodoverriding;

class Base4 {
    public int baseVar;
    public int var;

    public Base4(int v){
        baseVar=v;
        System.out.println("Base4 class parameterized constructor");
    }
}

class Der extends Base4 {
    public int derVar;
    public int var;

    public Der(int v){
        super(v);
        derVar=v;
        System.out.println("Derived class parameterized constructor");
    }

    public void display() {
        System.out.println("Base4 variable value=" + baseVar);
        System.out.println("Derived variable value=" + derVar);
    }

    public void useOfSuper() {
        var = 15;
        var = 20;
        System.out.println("Base4 variable var=" + super.var);
        System.out.println("Derived variable var=" + var);
    }
}

class Snip3 {
    public static void main(String args[]) {
        Der Derobj = new Der(10);
        Derobj.display();
        Derobj.useOfSuper();
    }
}

