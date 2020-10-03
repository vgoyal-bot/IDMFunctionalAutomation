package snippets.java.methodoverriding;

class Base1{
    public int baseVar = 1000;
    public Base1(){
        baseVar++;
    }
    public void display(){
        System.out.println("Base Variable:"+baseVar);
    }
}

class Derived extends Base1 {
    private int derVar;

    public Derived(int derVar) {
        this.derVar=derVar;
    }
    @Override
    public void display(){
        System.out.println("Base Variable:"+baseVar+"Derived Variable:"+derVar);
    }
}
class Snip2{
    public static void main(String args[]){
        Base1 baseOne=new Base1();
        baseOne.display();
        Derived derOne=new Derived(10);
        derOne.display();
    }
}

