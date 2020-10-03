package snippets.java.multithreading;

public class ExtendThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("Inside run method");
    }

    public static void main(String[] args) {
        ExtendThreadClass obj = new ExtendThreadClass();
        obj.start();
    }
}
