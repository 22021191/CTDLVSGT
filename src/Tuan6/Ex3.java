package Tuan6;
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

    public static void insertionSort1(int n, List<Integer> arr) {
        for(int i = 0;i<n;i++){
            int j=i;
            while(j>0&&arr.get(j)<=arr.get(j-1)){
                int tmp=arr.get(j);
                arr.set(j,arr.get(j-1));
                for(int k=0;k<n;k++){
                    System.out.print(arr.get(k)+" ");
                }
                arr.set(j-1,tmp);
                j--;
                System.out.println();
            }

        }
        // Write your code here
        for(int k=0;k<n;k++){
            System.out.print(arr.get(k)+" ");
        }

    }
}

public class Ex3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultEx3.insertionSort1(n, arr);

        bufferedReader.close();
    }
}

