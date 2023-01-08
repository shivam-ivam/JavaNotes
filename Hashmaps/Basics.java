package Hashmaps;
import java.util.HashMap;
import java.util.Set;
public class Basics {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("china", 150);
        hm.put("US", 50);


        // System.out.println(hm.get("India"));
        // hm.isEmpty();
        // // hm.clear(); // clean complete map
        // hm.size();
        // hm.remove("china");
        // System.out.println(hm);

        //                      Iterate 
        System.out.println(hm.keySet());
        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("key="+k+",value="+hm.get(k));
            
        }
    }
}
