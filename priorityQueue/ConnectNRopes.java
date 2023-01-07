package priorityQueue;
// given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
import java.util.*;
public class ConnectNRopes {
public static void main(String[] args) {
    int arr[] = {4,3,2,6};
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
        pq.add(arr[i]);
    }
    int cost = 0;
    while (pq.size() > 1) {
        int min = pq.remove();
        int min2 = pq.remove();
        cost += min + min2;
        pq.add(min2+min);
    }
    System.out.println(cost);
}    

}
