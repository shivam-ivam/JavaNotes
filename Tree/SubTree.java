package Tree;

import java.util.*;;

public class SubTree {
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

    public static class Tree {
        int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
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
        public Node find(Node root, Node root2) {
            if(root == null){
                return null;
            }
            if(root2.data == root.data){
                return root;
            }
            Node left = find(root.left, root2);
            Node right = find(root.right, root2);
            if(left != null){
                return left;
            }else{
                return right;
            }
        }
        public boolean isSubtree(Node root, Node subRoot) {
            if(root == null){
                return false;
            }
            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            
        }
        public boolean isIdentical(Node root, Node root2){
            if(root == null && root2 == null){
                return true;
            }else if(root == null || root2 == null || root.data != root2.data){
                return false;
            }
            if(!isIdentical(root.left, root2.left)){
                return false;
            }
            if(!isIdentical(root.right, root2.right)){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int nodes2[] = { 2, 4, -1, -1, 5, -1, -1 };
        Tree tr = new Tree();
        Tree tr2 = new Tree();
        Node root = tr.buildTree(nodes);
        Node root2 = tr2.buildTree(nodes2);
        tr.levelOrder(root);
        tr2.levelOrder(root2);
        System.out.println(tr.isSubtree(root,root2));
    }
}
