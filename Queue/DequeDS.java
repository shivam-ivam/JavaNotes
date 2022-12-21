package Queue;
import java.util.*;
// addFirst() // addLast() // removeFirst() // removeLast() // getFirst() // getLast()
public class DequeDS {
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(3);
        d.addLast(4);
        System.out.println(d);
        d.removeLast();
        System.out.println(d);
    }
}
