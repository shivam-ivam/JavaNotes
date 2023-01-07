package Heap;
// we are given N points in a 2D plane which are locations of N cars. if we are at the origin, print the nearest K cars.
import java.util.*;

public class NearbyCars {
    static class Cars implements Comparable<Cars> {
        String name;
        int x;
        int y;
        int disOrigin;
        public Cars(String name,int x, int y){
            this.name = name;
            this.x = x;
            this.y = y;
            this.disOrigin = x*x + y*y;
        }
        @Override
        public int compareTo(Cars c2) {
            return this.disOrigin - c2.disOrigin;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Cars> pq = new PriorityQueue<>();
        pq.add(new Cars("c0",3,3));
        pq.add(new Cars("c1",5,-1));
        pq.add(new Cars("c2",-2,4));
        for (int i = 0; i < 2; i++) {
            System.out.println(pq.peek().name);
            pq.remove();

        }

    }
}
