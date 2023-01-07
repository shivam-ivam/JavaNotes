package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Basic {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // ascending
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // descending
        pq.add(3); // O(logn)
        pq.add(2);
        pq.add(8);
        pq.add(5);
        while(!pq.isEmpty()){
            System.out.println(pq.peek()); // O(1)
            pq.remove();  // O(logn)
        }
    }
}
