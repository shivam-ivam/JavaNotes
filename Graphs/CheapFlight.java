package Graphs;
// there are n cities connected by some number of flights. You are given an array flights where flights[i] = [from, to, price] indicates that there is a flight.Your are also given three integers arc, dst and k, return the cheapest price from src to dst with at most k Stops. If ther is no such route, return -1. (all values are positive)
import java.util.*;
public class CheapFlight {

    
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
        graph[0].add(new Edge(0, 1, 100));

        // vertex - 1
        graph[1].add(new Edge(1, 2, 100));
        graph[1].add(new Edge(1, 3, 600));

        // vertex - 2
        graph[2].add(new Edge(2,3, 200));
        graph[2].add(new Edge(2,0, 100));

    }
    static class Pair{
        int n;
        int path;
        int stops;
        public Pair(int n, int path, int s){
            this.n = n; 
            this.path = path;
            this.stops = s;
        }
    }


    public static int cheapestFlight(ArrayList<Edge> graph[], int src,int dst, int k) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src, 0,0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(curr.stops > k){
                break;
            }
            if(!vis[curr.n]){
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    int stops = curr.stops;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v], stops+1));
                    }
                }
            }
        }
        System.out.println();
        return dist[dst];
    }
    

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        int price = cheapestFlight(graph, src, 3, 1);
        System.out.println(price);
    }
}
