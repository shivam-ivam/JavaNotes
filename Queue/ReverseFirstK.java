package Queue;
import java.util.*;
// we have an integer k and a Queue of integers, we need to reverse the order of the first k elements of the queue, leaving the elements in the same relative order.

public class ReverseFirstK {
    public static void reverseFirstK(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int right = q.size() - k;
        while (k-- > 0) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while(right-- > 0){
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            q.add(i);
        }
        System.out.println(q);
        reverseFirstK(q, 4);
        System.out.println(q);
    }
}
