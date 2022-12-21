// We are given a string S, we need to find the count of all contiguous substrings starting and ending with the same character.

public class ContiguousSubStr {
    public static void countSubStr(String str, int i, int j, int n) {
        if(i >= str.length()-1){
            return;
        }
        if(j >= str.length()){
            return;
        }
        if(str.charAt(i) == str.charAt(j-1)){
            System.out.println(str.substring(i, j));
        }
        countSubStr(str, i, j + 1, n);
        countSubStr(str, i+1, i+2, n);

    }

    public static void main(String args[]) {
        String str = "abcab";
        int n = str.length();
        countSubStr(str, 0, 1 ,n);
    }
}


// wrong