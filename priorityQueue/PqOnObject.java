package priorityQueue;

import java.util.PriorityQueue;

public class PqOnObject  {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 5));
        pq.add(new Student("P", 6));
        pq.add(new Student("C", 2));
        pq.add(new Student("B", 4));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().rank); 
            pq.remove(); 
        }
    }
}
