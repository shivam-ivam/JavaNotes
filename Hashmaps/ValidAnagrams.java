package Hashmaps;

import java.util.HashMap;
import java.util.Set;

public class ValidAnagrams {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> sm = new HashMap<>();
        HashMap<Character, Integer> tm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sm.containsKey(s.charAt(i))) {
                sm.put(s.charAt(i), sm.get(s.charAt(i)) + 1);
            } else {
                sm.put(s.charAt(i), 1);
            }
            if (tm.containsKey(t.charAt(i))) {
                tm.put(t.charAt(i), tm.get(t.charAt(i)) + 1);
            } else {
                tm.put(t.charAt(i), 1);
            }
        }
        Set<Character> keys = sm.keySet();
        for (Character key : keys) {
            if(tm.containsKey(key)){
                if(tm.get(key) != sm.get(key)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "race", t = "care";
        System.out.println(isAnagram(s, t));
    }
}
