package snippets.java.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetClass {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<String>();
        Set<String> treeSet = new TreeSet<String>();
        Set<String> linkedHashSet = new LinkedHashSet<String>();

        hashSet.add("Aaa");
        hashSet.add("Bbb");
        hashSet.add("Ccc");

        treeSet.add("Bbb");
        treeSet.add("Aaa");
        treeSet.add("Ccc");

        linkedHashSet.add("Ccc");
        linkedHashSet.add("Aaa");
        linkedHashSet.add("Bbb");

        System.out.println("HashSet :");
        for (Iterator<String> it = hashSet.iterator(); it.hasNext();)
            System.out.println("\t" + it.next());

        System.out.println("TreeSet :");
        for (Iterator<String> it = treeSet.iterator(); it.hasNext();)
            System.out.println("\t" + it.next());

        System.out.println("LinkeHashSet :");
        for (Iterator<String> it = linkedHashSet.iterator(); it.hasNext();)
            System.out.println("\t"+it.next());
    }
}