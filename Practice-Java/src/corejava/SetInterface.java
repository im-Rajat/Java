package corejava;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {
    public static void main(String[] args) {
        Set<Integer> values = new HashSet<>();
        values.add(512);
        values.add(8);
        values.add(10);
        values.add(5);  // duplicate elements not allowed in set
        System.out.println(values.add(5));  // print false

        for (int i : values) {
            System.out.print(i + " ");  // random sequence
        }

        Set<Integer> values2 = new TreeSet<>();
        values2.add(512);
        values2.add(8);
        values2.add(10);
        values2.add(5);  // duplicate elements not allowed in set
        System.out.println(values2.add(5));  // print false

        for (int i : values2) {
            System.out.print(i + " ");  // in ascending order
        }
    }
}
