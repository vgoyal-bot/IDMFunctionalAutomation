package snippets.java;

public class EnumClass {

    public enum week {
        SUNDAY, MONDAY, TUESDAY;
    }

    public static void main(String[] args) {
        for (week w : week.values()) {
            System.out.println(w);
        }

    }
}