import java.lang.reflect.Method;
import java.util.ArrayList;

public class Monotonic {
    public static boolean isMonotonic(ArrayList<Integer> list) {
        if(list.get(0) <= list.get(list.size()-1)){
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) > list.get(i+1)) {
                    return false;
                }
            }
        }else{
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) < list.get(i+1)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(1);
        System.out.println(isMonotonic(list));
    }
}
