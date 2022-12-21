package Queue;

public class CircularArrayQ {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front; 

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        // queue is empty or not
        public boolean isEmpty() {
            return rear == -1;
        }

        // full condition
        public boolean isFull() {
            return (rear+1)% size == front;
        }

        // add method --- // 
        public void add(int data) {
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }
        // remove 
        public int remove() {
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int result = arr[front] ; 
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front +1) %size;
            }
            rear--;
            return result;
        }

        // peek method
        public int peek() {
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[front];
        }

    }
public static void main(String[] args) {
    Queue q = new Queue(5);
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
