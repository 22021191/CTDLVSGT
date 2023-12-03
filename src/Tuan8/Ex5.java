package Tuan8;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class ResultEx5 {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    static PriorityQueue<Integer> LittleQueue = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> BigQueue = new PriorityQueue<Integer>();
    public static double Median(int a){
        if(BigQueue.isEmpty()||a>BigQueue.peek()){
            BigQueue.add(a);
        }else {
            LittleQueue.add(a);
        }
        if(BigQueue.size()-LittleQueue.size()>1){
            LittleQueue.add(BigQueue.poll());
        }else if(LittleQueue.size()-BigQueue.size()>1){
            BigQueue.add(LittleQueue.poll());
        }
        if(BigQueue.size()==LittleQueue.size()){
            return (double) (BigQueue.peek()+LittleQueue.peek())/2;
        }else {
            if(BigQueue.size()>LittleQueue.size()){
                return BigQueue.peek();
            }else {
                return LittleQueue.peek();
            }
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result=new ArrayList<Double>();
        // Write your code here
        for (int i = 0; i < a.size(); i++){
            result.add(Median(a.get(i)));
        }
        return result;
    }

}

public class Ex5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = ResultEx5.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
