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

class ResultEx2 {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void mergeSort( List<Integer> arr) {
        List<Integer> left=new ArrayList<Integer>();
        List<Integer> right=new ArrayList<Integer>();
        if(arr.size()<=1){
            return;
        }
        int mid=arr.size()/2;
        for(int i=0; i<mid; i++) {
            left.add(arr.get(i));
        }

        for(int i=mid; i<arr.size(); i++) {
            right.add(arr.get(i));
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }
    private static void merge(List<Integer> leftArray,
                              List<Integer> rightArray, List<Integer> array) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                array.set(k,leftArray.get(i));
                i++;
            } else {
                array.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        while (i < leftArray.size()) {
            array.set(k,leftArray.get(i));
            i++;
            k++;
        }
        while (j < rightArray.size()) {
            array.set(k,rightArray.get(j));
            j++;
            k++;
        }
    }

}

public class Ex2 {
    public static void main(String[] args) throws IOException {
        List<Integer> test=new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<7;i++){
            int k = scanner.nextInt();
            test.add(k);
        }
        ResultEx2.mergeSort(test);
        for (int i=0;i<7;i++){
            System.out.print(test.get(i)+" ");
        }

    }
}

