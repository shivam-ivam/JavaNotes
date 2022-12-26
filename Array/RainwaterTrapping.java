public class RainwaterTrapping {
public static void main(String arg[]) {
    int numbers[] = {4,2,0,6,3,2,5};
    int leftMax;
    int rightMax;
    int capacity = 0;
    for (int i = 0; i < numbers.length; i++) {
        // at start of each loop means for each array element rightMax and LeftMax will be
        // assigned same as the respected bar height 
        rightMax = numbers[i];
        leftMax = numbers[i];
        for (int j = i; j < numbers.length; j++) { /// right max find
            if(numbers[j] > rightMax){
                rightMax = numbers[j];
            }
        }
        for (int j = i; j >= 0; j--) {  /// left max find
            if (numbers[j] > leftMax) {
                leftMax = numbers[j];
            }
        } 
        // water level on that particular bar
        int waterlevel = Math.min(leftMax, rightMax) - numbers[i];
        // adding each water level into capacity to get the final capacity of water level
        capacity = capacity + waterlevel;
    }
    // printing the final capacity
    System.out.println("traped rainwater : " +capacity);
}    
}
