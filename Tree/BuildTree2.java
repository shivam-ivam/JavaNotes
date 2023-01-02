package Tree;
import java.util.LinkedList;
import java.util.Queue;

public class BuildTree2 {
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
    static class Tree{
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
        public int treeHeight(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);
            int finalHeight = Math.max(leftHeight, rightHeight) + 1;
            return finalHeight;

        }
        public int diameter(Node root) { // approach 1 // T.C : O(n^2) 
            if(root == null){
                return 0;
            }
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);
            int rightDiameter = diameter(root.right);
            int leftDiameter = diameter(root.left);
            int diameter = leftHeight + rightHeight +1;
            return Math.max(diameter, Math.max(rightDiameter, leftDiameter));

        }
        static class Info{
            int diam;
            int ht; 
            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public Info diameter2(Node root) {
            if(root == null){
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);
            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new Info(diam, ht);
        }
    }
        
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Tree tr = new Tree();
        Node root = tr.buildTree(nodes);
        tr.levelOrder(root);
        System.out.println(tr.diameter(root));
        System.out.println(tr.diameter2(root).diam);


    }
}
