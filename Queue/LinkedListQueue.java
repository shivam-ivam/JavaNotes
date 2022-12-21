package Queue;


public class LinkedListQueue{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue{

        Node head = null;
        Node tail = null;

        // queue is empty or not
        public boolean isEmpty() {
            return head == null;
        }

        // add method --- // 
        public void add(int data) {
            Node newNode = new Node(data);

            if(isEmpty()){
            tail = head = newNode;
            return;    
            }
            tail.next = newNode;
            tail = newNode;
        }
        // remove 
        public int remove() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int temp = head.data;
            head = head.next;
            return temp;

        }

        // peek method
        public int peek() {
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }

    }
public static void main(String[] args) {
    Queue q = new Queue();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    while(!q.isEmpty()){
        System.out.println(q.remove());
    }
} 
}