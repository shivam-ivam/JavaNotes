public class LinkedList2 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

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

    /////// --------- print arraylist -------//
    public void printLinkedList(Node head_) {
        Node temp = head_;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ------------- mid find ---------//

    public Node findMid(Node head_) {
        Node slow = head_;
        Node fast = head_.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge two linked list //
    public Node merge(Node leftHead, Node rightHead) {
        Node temp = new Node(-1);
        Node tempHead = temp;
        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return tempHead.next;
    }

    // mergesort
    public Node mergeSort(Node head_) {
        if (head_ == null || head_.next == null) {
            return head_;
        }
        Node midNode = findMid(head_);
        Node righNode = midNode.next;
        midNode.next = null;
        Node leftList = mergeSort(head_);
        Node rightList = mergeSort(righNode);
        Node merged = merge(leftList, rightList);
        return merged;
    }

    // detect a loop/ cycle in a linked list // using the approach of slow and fast
    // // logic is if slow == fast it means their must be a loop
    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeLoop() {
        Node slow = head;
        Node fast = head;
        Node prev = fast;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            prev = fast.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                flag = true;
                break;
            }
        }
        while (flag) {
            if (slow == fast) {
                prev.next = null;
                return;
            }
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

    }
    // ----------- Zig - Zag linked List --------//

    public Node reverse(Node head_) {
        Node prev = null;
        Node curr = head_;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // findMid(head) --> return mid
    public void zigZagList() {
        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        right = reverse(right);
        // zig zig mechanishm
        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            right = nextR;
            left = nextL;
        }
    }


    // -------------- Zig - Zag linked list end ------ //

    // ----------- ntersection of Two Linked Lists --//
    public Node findIntersection(Node head1, Node head2) {
        Node pt1 = head1;
        Node pt2 = head2;
        while(pt1 != null){
            while(pt2 != null){
                if(pt1 == pt2){
                    return pt1;
                }
                pt2 = pt2.next;
            }
            pt2 = head2;
            pt1 = pt1.next;
        }
        return null;
    }


    // ---------------------//
    // ---------------------------Delete N Nodes After M Nodes of a Linked List //

    public void DelNAftM(Node head_, int m, int n) {
        Node p1 = head_;
        Node p2;
        if(m >= size){
            return;
        }
        for (int i = 1; i < m; i++) {
            p1 = p1.next;
        }
        System.out.println(p1.data);
        p2 = p1;
        for (int i = 1; i < n+2; i++) {
            p2 = p2.next;
            if (p2 == null) {
                p1.next = null;
                return;
            }
        }
        p1.next = p2;
    }
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(5);
        ll.addFirst(1);
        ll.addFirst(9);
        ll.addFirst(0);
        ll.printLinkedList(ll.head);
        ll.DelNAftM(ll.head, 9, 2);
        ll.printLinkedList(ll.head);





        // LinkedList2 l2 = new LinkedList2();
        // l2.addFirst(0);
        // l2.addFirst(3);
        // l2.addFirst(4);
        // l2.addFirst(8);
        // l2.printLinkedList(l2.head);
        // l2.tail.next = ll.head.next.next.next;
        // l2.printLinkedList(l2.head);
        // Node result = ll.findIntersection(ll.head, l2.head);
        // System.out.println(result.data);

        // ll.zigZagList();
        // ll.printLinkedList(ll.head);

        // ll.printLinkedList(ll.head);
        // Node head_ = ll.mergeSort(ll.head);
        // ll.printLinkedList(head_);
        // ll.tail.next = ll.head;
        // System.out.println(ll.detectLoop());
        // ll.removeLoop();
        // System.out.println(ll.detectLoop());
        // ll.printLinkedList();
    }
}
