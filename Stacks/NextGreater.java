package Stacks;

import java.util.Stack;

public class NextGreater {
    public static void nextGreater(int arr[], int gre[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.empty()){
                gre[i] = -1;
            }else{
                gre[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 85, 100};
        int gre[] = new int[arr.length];
        nextGreater(arr, gre);
        for (int i = 0; i < gre.length; i++) {
            System.out.print(gre[i] + " ");
        }
    }
}
