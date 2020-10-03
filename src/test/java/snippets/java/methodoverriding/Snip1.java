package snippets.java.methodoverriding;

class Base {
    private static int baseVar = 0;
    public static int commonVar = 0;

    public Base() {
        baseVar++;
    }

    protected void printDetails() {
        System.out.println("BaseVariable:" + baseVar);
    }
}

class Snip1 extends Base {
    private static int derVar = 0;

    public Snip1(){
        commonVar++;
        derVar++;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Derived variable: " + derVar);
        System.out.println("CommonVar:" + commonVar);
    }

    public static void main(String args[]) {
        Snip1 childOne = new Snip1();
        Snip1 childTwo = new Snip1();
        Base baseOne = new Base();
        childTwo.printDetails();
    }
}
