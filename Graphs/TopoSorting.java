package Graphs;

import java.util.*;

public class TopoSorting {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex - 0

        // vertex - 1

        // vertex - 2
        graph[2].add(new Edge(2, 3));

        // vertex - 3
        graph[3].add(new Edge(3, 1));

        // vertex - 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // vertex - 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSorting(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                tSortingHelper(graph, visit, stack, i);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void tSortingHelper(ArrayList<Edge> graph[], boolean visit[], Stack<Integer> stack, int curr) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                tSortingHelper(graph, visit, stack, e.dest);
            }

        }
        stack.push(curr);
    }

    // using kahn's algorithm
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }


    // print all path
    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        if(src == dest){
            System.out.println(path+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
        
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // topologicalSorting(graph);
        topSort(graph);
        printAllPath(graph, 5,1, "");
    }
}
