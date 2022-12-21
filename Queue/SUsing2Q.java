package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class SUsing2Q {
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    
        public void push(int data) {
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }
        public int pop() {
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;
    
            // case 1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top); 
                }
            }
            return top;
        }
        public int peek() {
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;
    
            // case 1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }else{
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top); 
                }
            }
            return top;
        }

    }
    public static void main(String[] args) {
        Stack q = new Stack();
        q.push(1);
        q.push(2);
        q.push(3);
        while(!q.isEmpty()){
            System.out.println(q.pop());
        }
    }
    
}
