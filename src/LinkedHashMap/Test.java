package LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>(); // внутри не гарантируется никакого порядка
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // в каком порядке добавлены в том и будут
        Map<Integer, String> treeMap = new TreeMap<>(); // будут отсортированы по ключу (естестнвенный порядок)

//        testMap(hashMap);
//        testMap(linkedHashMap);
        testMap(treeMap);

    }
    public static void testMap(Map<Integer,String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob");

        for (Map.Entry<Integer, String> entry :  map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
