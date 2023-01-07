import java.util.ArrayList;

public class BSTToBalancedBst {
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
    public static Node arrToBST(ArrayList<Integer> arr, int si, int ei) {
        if(si>ei){
            return null;
        }
        int mid = si+((int)(ei-si)/2);
        Node root = new Node(arr.get(mid));
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
        ArrayList<Integer> arr = new ArrayList<>();
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.left.left = new Node(1);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);
        getTreeData(root,arr);
        Node root2 = arrToBST(arr, 0, arr.size()-1);
        inOrder(root);
        System.out.println();
        inOrder(root2);
        System.out.println();
        rootToLeafPath(root);
        System.out.println("second:");
        rootToLeafPath(root2);
    }
}
