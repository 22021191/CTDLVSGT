package Tuan7;

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

class ResultEx3 {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void quickSort(List<Integer> arr) {
        if(arr.size()<=1||arr==null) return;
        int pivot=arr.get(0);
        List<Integer> left=new ArrayList<Integer>();
        List<Integer> right=new ArrayList<Integer>();
        for(int i=1; i<arr.size(); i++) {
            if(arr.get(i) < arr.get(0)){
                left.add(arr.get(i));
            }else {
                right.add(arr.get(i));
            }
        }
        left.add(arr.get(0));
        quickSort(left);
        quickSort(right);
        int index=0;
        for (int i=0; i<left.size(); i++) {
            arr.set(index, left.get(i));
            index++;
        }
        for (int i=0; i<right.size(); i++) {
            arr.set(index, right.get(i));
            index++;
        }
    }


}

public class Ex3 {
    public static void main(String[] args) throws IOException {
        List<Integer> test=new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<7;i++){
            int k = scanner.nextInt();
            test.add(k);
        }
        ResultEx3.quickSort(test);
        for (int i=0;i<7;i++){
            System.out.print(test.get(i)+" ");
        }

    }
}

