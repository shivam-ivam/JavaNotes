package Queue;
import java.util.*;

public class QueueJCF {
    public static void main(String[] args) {
        // Queue q = new Queue(); --> this line will be wrong
        Queue<Integer> q = new LinkedList<>(); // Queue is not a class it is a interface // we can use linkedlist class or arraydeque class in order to implement Queue interface
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
