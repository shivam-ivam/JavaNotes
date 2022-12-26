package GreedyAlgorithm;

import java.util.Arrays;

// ques :- Given two arrays A and B of equal length n. Pair each element in array B, such that sum S of absolute differences of all the pairs is minimum.
// A =[1, 2, 3]
// B = [2, 1, 3]
public class SumAbsDiffPairs {
    public static void main(String[] args) {
        int A[] ={1, 2, 3};
        int B[] = {2, 1, 3};
        Arrays.sort(A);
        Arrays.sort(B);
        int minSum = 0;
        for (int i = 0; i < B.length; i++) {
            minSum += Math.abs(B[i]-A[i]);
        }
        System.out.println(minSum);
    }
}
