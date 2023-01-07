
public class SortedArrToBST{
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
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        Node root = arrToBST(arr, 0, arr.length-1);
        inOrder(root);
    }
}