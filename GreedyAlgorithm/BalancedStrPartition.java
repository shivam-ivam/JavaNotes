package GreedyAlgorithm;
// ques :- we have balanced string str of size N with an equal number of L and R, the task is to find a maximum number X, such that a given string can be partitioned into X balanced substring. A string is called to be balanced if the number of L's in the string equals the number of R's
import java.util.*;
public class BalancedStrPartition {
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int l=0;
        ArrayList<String> ansList = new ArrayList<>();
        StringBuilder substring = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'L'){
                l++;
            }else{
                l--;
            }
            substring.append(str.charAt(i));
            if(l == 0){
                ansList.add(substring.toString());
                substring = new StringBuilder("");
            }
        }
        System.out.println(ansList);
    }
}
