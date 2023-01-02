import java.util.*;

public class TopViewOfTree {
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

    static class Info {
        Node node;
        int horizontalDistance;

        Info(Node node, int horizontalDistance) {
            this.horizontalDistance = horizontalDistance;
            this.node = node;
        }
    }

    static void topView(Node root) {
        int min = 0, max = 0;
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                // insert data in hashmap according to the presence
                if(!map.containsKey(curr.horizontalDistance)){
                    map.put(curr.horizontalDistance, curr.node);
                }
                // add another information of the next level
                System.out.print(curr.node.data + " ");
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.horizontalDistance-1));
                    min = Math.min(curr.horizontalDistance-1, min);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.horizontalDistance+1));
                    max = Math.max(curr.horizontalDistance + 1, max);
                }
            }
        }
        System.out.println();
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        topView(root);
    }
}