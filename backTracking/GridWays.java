package backTracking;

public class GridWays {
    // T.C = O(2^n)


    public static int row = 10;
    public static int column = 10; 
    public static int gridArr[][] = new int[row][column];
    public static int gridWays(int i, int j) {

        if(i == gridArr.length-1 || j == gridArr[0].length-1){
            return 1;
        }else if(i == gridArr.length || j==gridArr[0].length){
            return 0;
        }

        // right choice
        int rChoice = gridWays(i, j+1);
        // down choice
        int bChoice = gridWays(i+1, j);
        // total ways 
        int count = rChoice + bChoice;
        return count;
    }
    public static void main(String args[]) {
        System.out.println(gridWays(0, 0));

        // by using permutation combination 
        // ((n-1)+(m-1))! / ((n-1)! (m-1)!)
        // the time complexity will be linear in this case

    }
}
