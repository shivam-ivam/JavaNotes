package GreedyAlgorithm;
import java.io.Writer;
import java.util.*;
// que :- given the weights and values of N items. put these items in a knapsack of capacity W to get the maximum total value in the knapsack
public class knapsack {
    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;
        double ratio[][] = new double[value.length][2];
        // 0th col => idx; 1st col => ratio
        for(int i = 0; i < ratio.length; i++) {
           ratio[i][0] = i;
           ratio[i][1] = value[i]/(double)weight[i]; 
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalVal += value[idx];
                capacity -= weight[idx];
            }else{
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("final value :"+ finalVal);
    }
}
