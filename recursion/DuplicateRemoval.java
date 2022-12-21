public class DuplicateRemoval {
    public static void duplicateRemoval(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()-1){
            System.out.println(newStr);
            return;
        }
        if(map[str.charAt(idx) - 'a'] != true){
            newStr = newStr.append(str.charAt(idx));
            map[str.charAt(idx) - 'a'] = true;
        }
        duplicateRemoval(str, idx+1, newStr, map);
    }
    public static void main(String args[]) {
        String str = "appnnacollege";
        boolean map[] = new boolean[26];
        StringBuilder newStr = new StringBuilder("");
        duplicateRemoval(str, 0, newStr, map);
    }
}
