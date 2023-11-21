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

class ResultEx4 {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int min;
        Collections.sort(arr);
        min = arr.get(1)-arr.get(0);
        for (int i = 0; i < arr.size()-1; i++) {
            if(arr.get(i+1)-arr.get(i) < min){
                min= arr.get(i+1)-arr.get(i);
            }
        }
        for (int i = 0; i < arr.size()-1; i++) {
            if(arr.get(i+1)-arr.get(i) == min){
                ans.add(arr.get(i));
                ans.add(arr.get(i+1));
            }
        }

        return ans;

    }

}

public class Ex4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ResultEx4.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
