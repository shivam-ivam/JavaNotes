import java.lang.annotation.Target;
import java.util.*;
public class PairSum {
    public static boolean pairSum(ArrayList<Integer> height, int target) {// T.C = O(n^2)
        for (int i = 0; i < height.size(); i++) {
            if(height.get(i) > target){
                break;
            }
            for (int j = i+1; j < height.size(); j++) {
                if(height.get(i) + height.get(j) == target){
                    return true;
                }else if(height.get(i) + height.get(j) > target){
                    break;
                }
            }
        }
        return false;
    }
    public static boolean pairSumOptimized(ArrayList<Integer> height, int target) { // 2 pointer approach // T.C = O(n)
        int lp = 0;
        int rp = height.size()-1;
        while (lp < rp) {
            int sum = height.get(rp) + height.get(lp);
            // case 1 
            if(sum == target){
                return true;
            }else if(sum > target){ // case 2
                rp--;
            }else if(sum < target){ // case 3
                lp++;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(2);
        height.add(3);
        height.add(4);
        height.add(5);
        height.add(6);
        System.out.println(pairSum(height, 12));
        System.out.println(pairSumOptimized(height, 4));

    }
}
