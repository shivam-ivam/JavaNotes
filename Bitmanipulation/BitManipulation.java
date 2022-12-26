public class BitManipulation {
    public static void CheckEvenOdd(int a) {
          if((a & 1) == 1){
            System.out.println("the number is odd");
          }else{
            System.out.println("the number is even");
          }
    }
    public static int getithBit(int n, int i) {
        int bitMask = i<<i;
        if(( n & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int clearithBit(int n, int i) {
        int bitMask = ~(i<<i);
  return n & bitMask;
    }

    public static int setithBit(int n, int i) {
        int bitMask = i<<i;
        return n | bitMask;
    }

    public static int updateIthBit(int a, int i, int b){
        if( b == 1){
            int bitMask = 1 << i;
            return a | bitMask;
        }else{
            int bitMask = ~(1<<i);
            return a & bitMask;
        }
    }
    public static int clearLastIBits(int a, int i) {
        // int bitMask = 1;
        // for (int j = 1; j < i; j++) {
        //     bitMask = bitMask << 1;
        //     bitMask = (bitMask + 1) ;
        // }
        // bitMask = ~(bitMask);
        // return a & bitMask;

        // method : 2
        int bitMask = (~0)<<i;
        return a & bitMask;

    }
    public static int clearRangeOfBits(int a, int i, int j) {
        // int bitMask = 1;
        // for (int k = 1; k < j-i +1; k++) {
        //     bitMask = bitMask << 1;
        //     bitMask = (bitMask + 1) ;
        // }
        // bitMask = bitMask << i-1;
        // bitMask = ~(bitMask);
        // return a & bitMask;

        // method : 2

        int bitMask =  ((~0)<< j) | (1<<(i-1))-1 ;
        return bitMask & a;
    }

    public static boolean powerOf2OrNot(int n) {
        return ((n & (n-1)) == 0);
    }

    // ---------- count set Bits in a number----------
    public static int countBits(int a) {
        int count = 0;
        while(a != 0){
            if( (a & 1) != 0 ){
                count++;
            }
            a = a>>1;
        }
        return count;
    }

    public static int fastExponentiation(int a, int n) {
         int ans = 1;
         while(n > 0){
            if((n & 1) != 0 ){
                ans = ans * a;
            }
            a = a * a;
            n = (n>>1);
         }
         return ans;
    }

    public static int addOne(int n) {
        return -~n;
    }
    public static void toLowerCase(char a) {
        System.out.println((int)a);
        System.out.println((int)(' '));
        System.out.println(a|' ');
        System.out.println((char)(a | ' '));
    }
    public static void main(String args[]) {
        // System.out.println(5 & 6);
        // CheckEvenOdd(4);
        // System.out.println(updateIthBit(5, 3, 1));
        // System.out.println(clearLastIBits(11, 2));
        // System.out.println(clearRangeOfBits(15, 2, 3));
        // System.out.println(powerOf2OrNot(32));
        // System.out.println(countBits(15));
        // System.out.println(fastExponentiation(3, 5));
        // int n = 'a';
        // System.out.println(addOne(33)); 
        toLowerCase('F');
    }
}
