package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

// You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can come after (a,b) if b<c.
// find the longest chain which can be formed from a given set of pairs.
public class ChainofPairs {
    public static void main(String[] args) { // T.C  = O(nlogn)
        int pairs[][] = {{5,24}, {39, 60}, {5,28}, {27,40}, {50,90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int chainEnd = pairs[0][1];
        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0] > chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("max length of chain = "+ chainLen);
    }
}
