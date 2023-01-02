package BinarySearchTrees;

public class BSTsearch {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static boolean bstSearch(Node root, int key) {
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        boolean result ;
        if(root.data > key){
            result = bstSearch(root.left, key);
        }else{
            result = bstSearch(root.right, key);
        }
        return result;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(6);
        inOrder(root);
        System.out.println(bstSearch(root, 8));
    }
}
