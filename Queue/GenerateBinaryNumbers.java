package Queue;

/// given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.
// input n = 2 ----------- output : 1 10 
import java.util.*;

public class GenerateBinaryNumbers {
    public static int toBinary(int n) {
        Stack<Integer> s = new Stack<>();
        while (n != 0) {
            s.push(n % 2);
            n = (int) (n / 2);
        }
        while (!s.isEmpty()) {
            n = n * 10 + s.pop();
        }
        return n;
    }

    public static void generateBinaryNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(toBinary(i));
        }
    }

    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<String>();
        q.add("1");
        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }

    public static void main(String[] args) {
        // System.out.println(toBinary(13));
        generatePrintBinary(5);
        generateBinaryNumbers(5);
    }
}
