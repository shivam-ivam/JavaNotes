package backTracking;

public class Permutaion {
    public static void subSets(String str, String ans) { 
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            subSets(newStr, ans+curr);
        }

    }
    public static void main(String args[]) {
        String str = "abc";
        subSets(str, "");
    }
}
