package Stacks;
import java.util.LinkedList;
import java.util.Stack;
public class Palindrome {
    public static boolean isPalindrome(LinkedList<Character> list) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < list.size() ; i++) {
            s.push(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            if(s.peek() == list.get(i)){
                s.pop();
            }else{
                return false;
            }
        }
        return true;
    }
 public static void main(String[] args) {
        
    LinkedList<Character> list = new LinkedList<>();
    list.addLast('a');
    list.addLast('b');
    list.addLast('c');
    list.addLast('e');
    list.addLast('a');
    System.out.println(isPalindrome(list));
 }   
}
