package BinarySearchTrees;

public class MirrorBST {
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
    public static Node mirrorBST(Node root) {
        if(root == null){
            return null;
        }
        Node root1 = mirrorBST(root.left);
        Node root2 = mirrorBST(root.right);
        root.left = root2;
        root.right = root1;
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(6);
        inOrder(root);
        mirrorBST(root);
        System.out.println();
        inOrder(root);
    }
}
