import java.io.*;
import java.util.*;


public class FriendsPairing {
public static int friendsPairing(int n) {
    if(n == 1 || n==2){
        return n;
    }
    return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
}    
    public static void main(String args[]) {
        // int n = 3;
        // System.out.println(friendsPairing(n));
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String str = "";
        for (int i = A.length()-1; i >= 0; i--) {
            str += A.charAt(i);
        }
        System.out.println(str);
        if(A.equals(str)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
