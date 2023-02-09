import java.util.*;

public class ContainerWithMostWater {
    public static int mostWater(ArrayList<Integer> height) { // T.C = O(n^2) 
        int maxWater = 0;
        for (int i = 0; i < height.size() - 1; i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int area = Math.min(height.get(i), height.get(j)) * (j - i);
                maxWater =  Math.max(maxWater, area);
            }
        }
        return maxWater;
    }
public static int mostWaterOptimized(ArrayList<Integer> height) { // 2 pointer Approach  // T.C = O(n) 
    int maxArea = 0;
    int lp = 0;
    int rp = height.size()-1;
    while (rp > lp) {
        int area = Math.min(height.get(rp),height.get(lp)) * (rp-lp);
        maxArea = Math.max(maxArea, area);
        if(height.get(rp) > height.get(lp)){
            lp++;
        }else{
            rp--;
        }
    }
    return maxArea;
}   public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8); 
        height.add(3);
        height.add(7);
        System.out.println(mostWater(height));
        System.out.println(mostWaterOptimized(height));
    }
}
