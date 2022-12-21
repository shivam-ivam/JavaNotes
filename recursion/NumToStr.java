public class NumToStr{
    public static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
    public static String str1 = "";
    public static void numToStr(int n) {
        if(n == 0){
            return;
        }
        
        int r = n%10;
        numToStr(n/10);
        // System.out.print(digits[r]+" ");
        str1 = str1 +" "+ digits[r];
    }
    public static void main(String str[]) {
        numToStr( 2765);
        System.out.println(str1);
    }
}