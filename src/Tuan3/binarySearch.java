package Tuan3;

import java.util.Scanner;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class binarySearch {

//    public static void main(String[] args) {
//        int n;
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        int[] a=new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//        Arrays.sort(a);
//        int number = scanner.nextInt();
//        int b=binarySearch(a, number);
//        System.out.println(b);
//
//    }
    public static int binarySearch(int[] a, int number){
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if      (number < a[mid]) r = mid - 1;
            else if (number > a[mid]) l = mid + 1;
            else return mid;
        }
        return -1;
    }


}
