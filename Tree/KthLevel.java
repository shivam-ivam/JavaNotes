public class KthLevel {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void kthLevelPrint(int level, Node root, int k) {
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        if(root == null){
            return;
        }
        kthLevelPrint(level+1, root.left, k);
        kthLevelPrint(level+1, root.right, k);
    }
  
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        kthLevelPrint(1,root,2);
    }
}
