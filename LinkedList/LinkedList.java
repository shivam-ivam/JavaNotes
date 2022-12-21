public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLinkedList() {
        if (head == null) {
            System.out.print("Linked list is empty.");
            return;
        }
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addMiddle(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
            count++;
            temp = temp.next;
        }
        addLast(data);
    }

    public void removeHead() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
        }
        head = head.next;
        size--;
    }

    public void removeTail() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size--;
    }
    public void searchItr(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if(temp.data == key){
                System.out.println("Found the key at index : "+ i);
                return;
            }          
            i++;
            temp = temp.next;  
        }
        System.out.println("Key Not Found");
    }
    public int helper(Node temp, int key) {
        if(temp == null){
            return -1;
        }
        if(temp.data == key){
            return 0;
        }
        int idx = helper(temp.next,key);
        if(idx == -1){
            return -1;
        }
        return idx + 1;
    }
    public int searchRecursive(int key) {
       return helper(head, key);
    }

    public void reverseLinkedList() {
        Node prev = head;
        Node curr = head.next;
        Node next;
        head.next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        next = head;
        head = tail;
        tail = head;
    }
    public void deleteNthFromEnd(int n) {
        if(n == size){
            head = head.next;
            return;
        }
        int siz = size-n+1;
        Node prev = head;
        for (int i = 1; i < siz-1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
    public Node findMid(Node head_) { // slow fast approach // helper function for isPalindrome
        Node slow = head_;
        Node fast = head_;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
         }
        return slow; // slow will be my midNode

    }
    public boolean isPalinDrome() {
        if(head == null || head.next == null){
            return true;
        }
        Node midNode = findMid(head);
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(1);
        // ll.printLinkedList();
        // ll.addFirst(2);
        // ll.printLinkedList();
        // ll.addLast(5);
        // ll.printLinkedList();
        // ll.addLast(8);
        // ll.printLinkedList();
        // ll.addMiddle(11, 2);
        // ll.printLinkedList();
        // // ll.removeHead();
        // // ll.printLinkedList();
        // // ll.removeTail();
        // // ll.searchItr(8);
        // // System.out.println(ll.searchRecursive(8));
        // // ll.reverseLinkedList();
        // ll.deleteNthFromEnd(5);
        // ll.printLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(3);
        ll.addLast(9);
        ll.addLast(1);
        ll.printLinkedList();
        // System.out.println(ll.isPalinDrome());
        ll.deleteNthFromEnd(3);
        ll.printLinkedList();
    }
}