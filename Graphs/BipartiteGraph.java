package Graphs;

import java.util.*;;

public class BipartiteGraph {
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
        graph[0].add(new Edge(0, 3, 1));

        // vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));

        // vertex 3
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 1));

    }

    // A bipartite graph is a graph whose vertices can be divided into two
    // independent sets, U and V such that every edge (u,v) either connects a vertex
    // from U to V or a vertex from V to U. In other words, for every edge (u,v),
    // either u belongs to U and v to V, or u belongs to V and v to U, we can also
    // say that there is no edge that connects vertices of same set.

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
