package Queue;

import java.util.Stack;

public class QUsing2Stacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // empty condition
        public boolean isEmpty() {
            return s1.empty();
        }

        // add method
        public void add(int data) {
            if(isEmpty()){
                s1.push(data);
                return;
            }
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.empty()){
                s1.push(s2.pop());
            }
        }
        // remove method
        public int remove() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // peek method
        public int peek() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
