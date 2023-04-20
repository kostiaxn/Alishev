package Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        // Before Java 5
        int idx = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if(idx == 1)
                iterator.remove();
            idx++;
        }
        // Java 5
        for (int x : list)
            System.out.println(x);
    }
}
