package Stacks;

import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean duplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char p = str.charAt(i);
            if(p == '('){
                s.push(p);
            }else if(p != ')' && s.peek() != 'c'){
                s.push('c');
            }else if(p == ')'){
                if(s.peek() == 'c'){
                    s.pop();
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "((a+b)+((c+d)))";
        System.out.println(duplicateParenthesis(str));
    }
}
