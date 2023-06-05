package corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionClass {
    public static void main(String[] args) {
        List<Integer>values = new ArrayList<>();
        values.add(404);
        values.add(908);
        values.add(639);
        values.add(265);
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                //return i % 10 > j % 10 ? 1 : -1;
                if (i % 10 > j % 10) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(values, c);
        // using lambda expression
        Comparator<Integer> c2 = (i, j) -> i % 10 > j % 10 ? 1 : -1;
        Collections.sort(values, c2); // both c and c2 are exactly same

        // one liner
        // Collections.sort(values, (i, j) -> i % 10 > j % 10 ? 1 : -1;);

        for (Integer i : values) {
            System.out.print(i + " ");
        }
    }
}
