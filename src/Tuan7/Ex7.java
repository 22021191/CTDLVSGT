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

class ResultEx7 {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        quickSort(arr);
        return arr.get(arr.size()/2);

    }
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

public class Ex7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultEx7.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
