import java.util.*;
class ArrayListBasic{
public static void main(String args[]) {

    ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    System.out.println(mainList);
    list.add(23);
    list.add(34);
    list.add(45);
    mainList.add(list);
    list.add(56);
    list.add(90);
    mainList.add(list);
    // System.out.println(list);
    System.out.println(mainList);

}
}