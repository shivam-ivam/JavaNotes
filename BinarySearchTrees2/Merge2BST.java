
import java.util.*;

public class Merge2BST {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static Node arrToBST(int arr[], int si, int ei) {
        if(si>ei){
            return null;
        }
        int mid = si+((int)(ei-si)/2);
        Node root = new Node(arr[mid]);
        root.left = arrToBST(arr, si, mid-1);
        root.right = arrToBST(arr, mid+1, ei);
        return root;
    }
    public static void getTreeData(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getTreeData(root.left, arr);
        arr.add(root.data);
        getTreeData(root.right, arr);
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
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
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        ArrayList<Integer> arr1 = new ArrayList<>();
        getTreeData(root1, arr1); 
        getTreeData(root2, arr1);
        int finalArr[] = new int[arr1.size()]; 
        for (int i = 0; i < finalArr.length; i++) {
                finalArr[i] = arr1.get(i);
        }
        Arrays.sort(finalArr);
        Node root = arrToBST(finalArr, 0, finalArr.length-1);
        inOrder(root);
        System.out.println();
        rootToLeafPath(root);
    }
}
