// interleave 2 halves of a queue (even length)
// example : 1 2 3 4 5 6 7 8 9 10  ==> 1 6 2 7 3 8 4 9 5 10
package Queue;
import java.util.Queue;
import java.util.LinkedList;

public class Interleave2Halves {
    public static void interleaveQueue(Queue<Integer> q) {
        int mid = q.size()/2;
        Queue<Integer> q1 = new LinkedList<>();
        // Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < mid; i++) {
            q1.add(q.remove());
        }
        // for (int i = 0; i < mid; i++) {
        //     q2.add(q.remove());
        // }
        for (int i = 0; i < 2*mid; i++) {
            if(i%2 == 0){
                q.add(q1.remove());
            }else{
                q.add(q.remove());
            }
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        interleaveQueue(q);
        System.out.println(q);



        
    }
}
