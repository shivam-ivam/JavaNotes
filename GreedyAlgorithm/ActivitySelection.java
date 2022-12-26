package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};


        // // end time basis sorted
        // int maxAct = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // // 1st activity 
        // maxAct = 1;
        // ans.add(0);
        // int lastEnd = end[0];
        // for (int i = 0; i < end.length; i++) {
        //     if(start[i] >= lastEnd){
        //         // activity select
        //         maxAct++;
        //         ans.add(i);
        //         lastEnd = end[i];
        //     }
        // }
        // System.out.println("max activity = " + ans);
        
    ////// ----------- if we have no sorted end time
    
        // sorting 
        int activity[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        // lambda function -> shortform
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));

        

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity 
        maxAct = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2];
        for (int i = 0; i < end.length; i++) {
            if(activity[i][1] >= lastEnd){
                // activity select
                maxAct++;
                ans.add(i);
                lastEnd = activity[i][2];
            }
        }
        System.out.println("max activity = " + ans);
    }


}
