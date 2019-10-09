package snippets.java.multithreading;

public class ImplementsRunnableInterfaceClass implements Runnable {
    public void run() {
        System.out.println("Inside run method");
    }

    public static void main(String[] args) {
        ImplementsRunnableInterfaceClass obj = new ImplementsRunnableInterfaceClass();

        Thread obj1 = new Thread(obj);
        obj1.start();
    }
}
