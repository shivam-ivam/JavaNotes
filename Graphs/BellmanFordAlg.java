package Graphs;
import java.util.*;
// shortest path from the source to all vertices (negative edges)
// note - doesn't work for negative weight cycles 
public class BellmanFordAlg {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex - 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // vertex - 1
        graph[1].add(new Edge(1, 2, -4));

        // vertex - 2
        graph[2].add(new Edge(2,3, 2));

        // vertex - 3
        graph[3].add(new Edge(3,4, 4));

        // vertex - 4
        graph[4].add(new Edge(4,1, -1));

    }

    public static void bellmanFord(ArrayList<Edge> graph[] , int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if(i != src){ 
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < graph.length-1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int j2 = 0; j2 < graph[i].size(); j2++) {
                    Edge e = graph[i].get(j2);
                    if( dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]){
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }

            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        bellmanFord(graph, 0);
    }
}
