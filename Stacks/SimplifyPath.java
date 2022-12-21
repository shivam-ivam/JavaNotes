package Stacks;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String str) {
        StringBuilder simStr = new StringBuilder("");

        Stack<Character> s = new Stack<>();
        for (int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i) == '/' && !s.empty()){
                s.push(str.charAt(i));
            }else if(str.charAt(i) == '.'){
                if(str.charAt(i+1) != '/'){
                    return "invalid path";
                }
                if(str.charAt(i-1) == '/'){
                    i -= 1;
                }else if(str.charAt(i-2) == '/' && str.charAt(i-1) == '.'){
                    i -= 2;
                    while (str.charAt(i-1) != '/') {
                        i--;
                    }
                }else{
                    return "invalid path";
                }
            }else if(str.charAt(i) != '/'){
                s.push(str.charAt(i));
            }
        }
        while (!s.empty()) {
            simStr.append(s.pop());
        }


        return simStr.toString();
    }
    public static void main(String[] args) {
        String str = "/sdf/apnacollege/../";
        System.out.println(simplifyPath(str));
    }
}
