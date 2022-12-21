package Queue;

public class ArrayQueue {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        // queue is empty or not
        public boolean isEmpty() {
            return rear == -1;
        }

        // add method --- // 
        public void add(int data) {
            if(rear == size-1){
                System.out.println("queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }
        // remove 
        public int remove() {
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int front = arr[0] ; //front must be the first one always
            // shift all the elements one step left // in order to remove first element
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        // peek method
        public int peek() {
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }

    }
public static void main(String[] args) {
    Queue q = new Queue(5);
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    while(!q.isEmpty()){
        System.out.println(q.remove());
    }
}    
}
