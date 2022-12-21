public class FindLenOfString {
    public static int findLenOfString(String str, int i) {
        if(str == ""){
            return i;
        }
        str = str.substring(1);
        i = findLenOfString(str, i);
        return i+1;
    }
    public static void main(String str[]) {
        System.out.println(findLenOfString("shivam", 0));
    }
}
