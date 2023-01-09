package HashSet;
import java.util.*;
public class Iteration {
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

        //  using Itrator 
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // advance for loop
        for (Integer s : set) {
            System.out.println(s);
        }
    }
}
 