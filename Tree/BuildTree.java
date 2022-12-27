package Tree;

import java.util.LinkedList;
import java.util.Queue;


public class BuildTree { // T.C = O(n)
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

    static class BinaryTree {
        static int idx = -1;

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

        public void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
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
        public int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = countNodes(root.left);
            int rightHeight = countNodes(root.right);
            int finalHeight = leftHeight + rightHeight + 1;
            return finalHeight;
        }
        public int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftNodeSum = sumNodes(root.left);
            int rightNodeSum = sumNodes(root.right);
            int finalsum = leftNodeSum + rightNodeSum + root.data;
            return finalsum;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrder(root);
        System.out.println("\n"+tree.treeHeight(root));
        System.out.println("\n"+tree.countNodes(root));
        System.out.println("\n"+tree.sumNodes(root));
        
    }
}
