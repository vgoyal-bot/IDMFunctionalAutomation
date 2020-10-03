package snippets.java.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author evingoy
 *
 */
public class ListClass {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("Vinit");
        list.add("Nidhi");

        // Elements stored in the list the way they are added.
        System.out.println(list);

        // Elements stored in the list the way they are added.
        // Allow duplicate values
        List<String> linkedList = new LinkedList();
        linkedList.add("Ashu");
        linkedList.add("Vinit");
        linkedList.add("Ashu");
        System.out.println(linkedList);
    }
}
