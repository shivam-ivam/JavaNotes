package BinarySearchTrees;

import java.util.ArrayList;

public class RootToLeafPath {
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
    static ArrayList<Integer> path = new ArrayList<>();
    public static void rootToLeafPath(Node root) {
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println();
        }
            rootToLeafPath(root.left);
            rootToLeafPath(root.right);
            path.remove(path.size()-1);

    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.left.right = new Node(10);
        root.left.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        rootToLeafPath(root);
    }
}
