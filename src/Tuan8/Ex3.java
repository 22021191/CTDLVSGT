package Tuan8;
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
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i<A.size(); i++) {
            queue.add(A.get(i));
        }
        while (true){
            int x=queue.peek();
            queue.remove(x);
            if(x>k){
                return count;
            }else {
                if(queue.size()==0){
                    return -1;
                }else{
                    int y=queue.peek();
                    queue.remove(y);
                    if(y>k){
                        return ++count;
                    }else{
                        if(queue.size()==0){
                            return -1;
                        }
                        queue.add(x+2*y);
                    }
                }
            }
            count++;
        }

    }
}

public class Ex3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultEx3.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
