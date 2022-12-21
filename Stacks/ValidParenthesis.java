package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean validParenthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char p = str.charAt(i);
            if (p == '(' || p == '{' || p == '[') {
                s.push(p);
            } else if (!s.empty()) {

                if ((p == ')' && s.peek() == '(') || (p == '}' && s.peek() == '{')
                        || (p == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!s.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "{()}}}";
        System.out.println(validParenthesis(str));
    }
}
