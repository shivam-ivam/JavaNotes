package BinarySearchTrees;

public class ValidBST {
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
    public static boolean isValidBst(Node root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        return isValidBst(root.right, root.data, max) && isValidBst(root.left, min, root.data);
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(6);
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        System.out.println(isValidBst(root, min, max));
    }
}
