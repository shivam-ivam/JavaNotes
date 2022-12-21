package backTracking;

public class NQueens {  // t.c = O(n!)
    public static int n = 4;
    public static char arr[][] = new char[n][n];

    public static void nQueens(int row) {
        if (row == arr.length) {
            printArr();
            return;
        }
        for (int j2 = 0; j2 < arr.length; j2++) {
            if(isSafe(row, j2)){
                arr[row][j2] = 'Q';
                nQueens(row + 1);
                // return;
                arr[row][j2] = '.';
            }
        }
    }
    public static boolean isSafe(int row, int j) {
        // vertical up
        for (int i = row-1; i >=0; i--) {
            if(arr[i][j] == 'Q'){
                return false;
            }
        }
        // diagonal left up
        for (int i = row-1, j2 = j-1; i >=0 && j2 >= 0; i--, j2--) {
            if(arr[i][j2] == 'Q'){
                return false;
            }
        }
        // diagonal right up
        for (int i = row-1, j2 = j+1; i >=0 && j2 < arr.length; i--, j2++) {
            if(arr[i][j2] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void put() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = '.';
            }
        }
    }

    public static void main(String args[]) {
        put();
        nQueens(0);
    }
}
