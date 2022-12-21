package Stacks;

import java.util.Stack;

public class MaxRectangle {
    public static int maxRectangle(int arr[]) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        // next smaller right 
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1; i >= 0 ; i--) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.empty()){
                right[i] = arr.length;
            }else{
                right[i] = s.peek();
            }
            s.push(i);
        }

        // next smaller left
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.empty()){
                left[i] = -1;
            }else{
                left[i] = s.peek();
            }
            s.push(i);
        }

        // current area : width = j-i-1 = right[i] - left[i]-1
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = right[i] - left[i] - 1;
            int current = arr[i] * width;
            maxArea = Math.max(maxArea, current);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};
        System.out.println(maxRectangle(arr));
    }
}
