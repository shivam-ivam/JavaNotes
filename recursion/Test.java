class Test{
    // public static int count(String str, int idx) {
    //     // base case
    //     if(idx == str.length()){
    //         return 0;
    //     }
    //     int ans = count(str, idx+1) + 1;
    //     return ans;
        
    // }
    // public static int count2(String str) {
    //     if(str == ""){
    //         return 0;
    //     }
    //     int ans = count2(str.substring(1)) + 1 ;
    //     return ans;
    // }
    // public static void main(String[] args) {
    //     String str = "abcde";
    //     System.out.println(count(str,0));
    //     System.out.println(count2(str));
    // }


    public static String numConvertalpha(int number[], int idx) {
        // base case 
        if(idx == number.length){
            return "";
        }
        String str = "";
        if(number[idx]== 1){
            str += " one";
        }else if(number[idx] == 2){
            str += " two";
        }else if(number[idx] == 3){
            str+= " three";
        }
        String str2 =  str + numConvertalpha(number, idx+1);
        return str2;
    }

    public static void main(String[] args) {
        int number[] = {1,2,3};
        String word = numConvertalpha(number, 0);
        System.out.println(word);
    }
}