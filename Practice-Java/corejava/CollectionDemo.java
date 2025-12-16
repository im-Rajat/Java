package corejava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {

        Collection values = new ArrayList();
        values.add(4);
        values.add(5);
        values.add(8);
        System.out.println(values);
        Iterator itr = values.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

