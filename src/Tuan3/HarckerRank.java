package Tuan3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HarckerRank {
    public static void main(String[] args) {
    }

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int[] lsum = new int[arr.size()];
        int[] rsum = new int[arr.size()];
        lsum[0] = 0;
        rsum[0] = 0;
        for (int i = 1; i < arr.size(); i++) {
            rsum[0] += arr.get(i);
        }

        for (int i = 1; i < arr.size(); i++) {
            lsum[i] = lsum[i - 1] + arr.get(i - 1);
            rsum[i] = rsum[i - 1] - arr.get(i) - arr.get(i - 1);
            if (rsum[i] == lsum[i]) {
                return "YES";
            }
        }
        return "NO";


    }
    public static void insertionSort1(int n, List<Integer> arr) {
        for(int i = 0;i<n;i++){
           int j=i-1;
           int tmp=arr.get(i);
           while (j>=0 && arr.get(j)>tmp){
               arr.set(j+1,arr.get(j));
               j--;
               for (int k=0;k<n;k++){
                   System.out.print(arr.get(k));
               }
               System.out.println("");

           }
           arr.set(j+1,tmp);
        }

        // Write your code here

    }


    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int min;
        Collections.sort(arr);
        min = arr.get(0) - arr.get(1);
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) < min) {
                min = arr.get(i + 1) - arr.get(i);
            }
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == min) {
                ans.add(arr.get(i));
                ans.add(arr.get(i + 1));
            }
        }
        System.out.println(min);
        return ans;

    }

    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int count = 0;
        int i = 1;
        int j = 0;
        while (j < arr.size() && i < arr.size()) {
            if (arr.get(i) - arr.get(j) > k) {
                j++;
            }
            if (arr.get(i) - arr.get(j) == k) {
                count++;
                i++;
            }
            if (arr.get(i) - arr.get(j) < k) {
                i++;
            }
        }
        // Write your code here
        return count;

    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int count = 0;
        int i = 0;
        int j = 1;
        int tmp = 0;
        while (i < (q.size() - 1)) {

            if (q.get(i) > q.get(j)) {
                tmp++;
            }
            j++;
            if(tmp>=3){
                System.out.println("Too chaotic");
                return;
            }
            if (j == q.size()) {
                i++;
                j=i+1;
                count+=tmp;
                tmp=0;
            }
        }
        System.out.println(count);
    }

}
