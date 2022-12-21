import java.util.ArrayList;
public class PairSumTwo {
    public static boolean pairSumOptimized(ArrayList<Integer> height, int target) { // 2 pointer approach // T.C = O(n)
        // to find the pivot point : 
        int pivot = 0;
        for (int i = 0; i < height.size()-1; i++) {
            if(height.get(i) > height.get(i+1)){
                pivot = i;
                break;
            }
        }
        int lp = pivot + 1;
        int rp = pivot;

        while (lp != rp) {
            int sum = height.get(rp) + height.get(lp);
            // case 1 
            if(sum == target){
                return true;
            }else if(sum > target){ // case 2
                rp = (height.size() + rp - 1) % height.size(); // modular arthmetic
            }else if(sum < target){ // case 3
                lp = (lp + 1) % height.size(); // modular arthmetic 
            }
        }
        return false;
    }
    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        System.out.println(pairSumOptimized(height, 16));

    }    
}
