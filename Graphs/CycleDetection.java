package Graphs;

import java.util.*;

public class CycleDetection {
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
        graph[0].add(new Edge(0, 3, 1));

        // vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // vertex 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // vertex 3
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        // vertex 4
        graph[4].add(new Edge(4, 3, 1));

    }

    public static boolean DetectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (DetectCycleutil(graph, i, -1, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DetectCycleutil(ArrayList<Edge>[] graph, int curr, int parent, boolean visit[]) {

        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                if (DetectCycleutil(graph, e.dest, e.src, visit)) {
                    return true;
                }
            } else if (visit[e.dest] && e.dest != parent) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        /*
         * 0 ---- 3
         * / | |
         * 1 | |
         * \ | 4
         * 2
         * 
         */

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(DetectCycle(graph));

    }
}
