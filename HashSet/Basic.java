package HashSet;

import java.util.*;

public class Basic {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(8);
        set.add(6);
        set.add(7);
        set.add(4);
        set.add(2);
        set.add(3);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains(2));
    }
}
