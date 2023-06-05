package corejava;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        List values = new ArrayList();
        values.add(4);  // Integer v = new Integer(4);
        values.add(5);  // argument is object not int
        values.add(8);
        values.add(2, 2);

        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }

        for (Object o : values) {
           System.out.print(o + " ");
        }
    }
}
