package Tuan8;
import java.io.*;
import java.util.*;

public class Ex2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int max=A.length()-1;
        for(int i=A.length()-1;i>=0;i--){
            if(A.charAt(i)!=A.charAt(max-i)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        return;
    }
}



