package corejava;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();  // it's not synchronized

        map.put("myName", "Raja");
        map.put("actor", "Raj");
        map.put("ceo ", "Marisa");
        map.put("actress", "Noha");
        map.put("actor", "Kunal");  // replace Raj

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + map.get(key)); // random order
        }

        System.out.println(map.get("actor"));
        System.out.println(map.get("hero"));    // print null
        System.out.println(map);     // random order

        Map<String, String> map2 = new Hashtable<>();   // it's synchronized
    }
}
