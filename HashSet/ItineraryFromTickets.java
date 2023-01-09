package HashSet;
// find Itinerary from tickets

import java.util.*;


// "chennai" => "bemngaluru"
// "mumbai"-> "delhi"
// "goa" -> "chennai"
// "delhi" -> "goa"

// ans ->  "mumbai" -> "goa" -> "chennai" -> "bengaluru"
public class ItineraryFromTickets {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> revMap = new HashMap<>();
        map.put("chennai", "bengaluru");
        map.put("mumbai", "delhi");
        map.put("goa", "chennai");
        map.put("delhi", "goa");
        for (String key : map.keySet()) {
            revMap.put(map.get(key), key);
        }
        String start = "";
        for (String key : map.keySet()) {
            if(!revMap.containsKey(key)){
                start = key;
            }
        }

        LinkedHashSet<String> set = new LinkedHashSet<>();
        while(true){
            set.add(start);
            if(!map.containsKey(start)){
                break;
            }
            start = map.get(start);
        }
        System.out.println(set);

    }
}
