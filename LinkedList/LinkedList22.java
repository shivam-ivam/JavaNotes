import java.util.LinkedList;
public class LinkedList22 {
    public static LinkedList<Integer> ll = new LinkedList<>();
    public static void main(String[] args) {

        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
    }
}
 