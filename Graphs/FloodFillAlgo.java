import java.util.*;
// given a m x n integer grid image where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc , and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

class FloodFillAlgo {
    public static void floodFill(int image[][], int sr, int sc, int color, int preColor) {
        if (sr >= image.length || sc >= image[0].length || sc < 0 || sr < 0 || image[sr][sc] != preColor) {
            return;
        }
        image[sr][sc] = color;
        // left
        floodFill(image, sr, sc - 1, color, preColor);
        // right
        floodFill(image, sr, sc + 1, color, preColor);
        // up
        floodFill(image, sr - 1, sc, color, preColor);
        // down
        floodFill(image, sr + 1, sc, color, preColor);
    }

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sr = 1;
        int sc = 1;
        int color = 2;
        int image[][] = {
                { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 }
        };
        print(image);

        floodFill(image, sr, sc, color, image[sr][sc]);

        print(image);

    }
}