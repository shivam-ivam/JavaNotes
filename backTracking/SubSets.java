package backTracking;

public class SubSets {
    public static void subSets(String str, String ans, int i) { // T.C = O(2^n * n)
        // base case 
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        // recursion 
        // choice yes
        subSets(str, ans + str.charAt(i), i+1);
        // choice no
        subSets(str, ans, i+1);
        
    }
    public static void main(String args[]) {
        String str = "abc";
        subSets(str, "", 0);
    }
}
