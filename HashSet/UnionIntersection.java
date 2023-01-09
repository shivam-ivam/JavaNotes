package HashSet;

import java.util.HashSet;

import javax.lang.model.type.IntersectionType;

// Union and intersection of 2 array
public class UnionIntersection {
    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6,3,9,2,9,4};
        HashSet<Integer> set2 = new HashSet<>(); 
        for (int i = 0; i < arr2.length; i++) {
         set2.add(arr2[i]);
        }
        System.out.println("Intersection:");
        for (int i = 0; i < arr1.length; i++) {
         if(set2.contains(arr1[i])){
            System.out.print(arr1[i] + " ");
         }
         set2.add(arr1[i]);
        }
        System.out.println("\nunion:\n" + set2);
    }
}
