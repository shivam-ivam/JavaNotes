package Graphs;

import java.util.*;

public class Traversal {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // vertex 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // vertex 3
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 1, 1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // vertex 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // vertex 6
        graph[6].add(new Edge(6, 5, 1));

        // vertex 7
        graph[7].add(new Edge(7, 8, 1));

        // vertex 8
        graph[8].add(new Edge(8, 7, 1));
        graph[8].add(new Edge(8, 9, 1));

        // vertex 9
        graph[9].add(new Edge(9, 8, 1));
    }



    public static void DFS(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                DFSutil(graph, i, vis);
            }
        }
    }

    public static void DFSutil(ArrayList<Edge>[] graph, int curr, boolean visit[]) { // Depth first Seearch
        if (visit[curr]) {
            return;
        }
        visit[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            DFSutil(graph, graph[curr].get(i).dest, visit);
        }
    }
  

    //////                 BFS modified  (in order to show each and every components of graph)
    public static void BFS(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                BFSutil(graph, vis,i);
            }
        }
    }

    public static void BFSutil(ArrayList<Edge>[] graph, boolean vis[], int j) { // Breadth First Search // T.C = O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(j);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                vis[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    // Has path
    // for given srx and dest, tell if a path exists from src to dest src = 0, dest
    // = 5

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (curr == dest) {
                return true;
            }
            if (!vis[curr]) {
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        /*
         *  1-----3
         * /      | \
         * 0      | 5 --- 6     7---8---9
         * \      | /
         *  2-----4
         * 
         */

        int V = 10;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        BFS(graph);
        System.out.println();
        DFS(graph);
        System.out.println();
        System.out.println(hasPath(graph, 6, 2));

    }
}
