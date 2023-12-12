package Bonus;

import java.util.List;
import java.util.PriorityQueue;
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

class MyPriority{
    List<Integer> priority=new ArrayList<Integer>();
    int size=0;
    MyPriority(){
        priority.add(0);
    }
    public boolean IsEmpty() {
        return size==0;
    }
    public int peek() {
        if(size==0){
            throw new NullPointerException();
        }else {
            return priority.get(1);
        }
    }
    public void add(int v){
        size++;
        priority.add(v);
        int currentIndex=size;
        int parentIndex=currentIndex/2;
        while (priority.get(parentIndex)>priority.get(currentIndex)&&parentIndex!=0){
            Swap(parentIndex,currentIndex);
            currentIndex=parentIndex;
            parentIndex=currentIndex/2;
        }
    }
    public void Swap(int i,int j) {
        int tmp=priority.get(i);
        priority.set(i,priority.get(j));
        priority.set(j,tmp);
    }
    public int poll(){
        if(size==0){
            throw new  NullPointerException();
        }
        int result=priority.get(1);
        priority.set(1,priority.get(size));
        priority.remove(size);
        size--;

        int currentIndex=1;
        while (2*currentIndex<=size){
            int leftnode=2*currentIndex;
            int index=leftnode;
            int rightnode=leftnode+1;
            if(rightnode<=size&&priority.get(rightnode)<priority.get(leftnode)){
                index=rightnode;
            }
            if(priority.get(currentIndex)>priority.get(index)){
                    Swap(currentIndex,index);
                    currentIndex=index;
            }else {
                return result;
            }
        }
        return result;
    }
}
class Result {

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int res = 0;
        MyPriority cookiesQueue = new MyPriority();
        for(int i=0; i<A.size(); i++) {
            cookiesQueue.add(A.get(i));
        }
        while (cookiesQueue.size >= 2 && cookiesQueue.peek() < k) {
            cookiesQueue.add(cookiesQueue.poll() + 2 * cookiesQueue.poll());
            res++;
        }
        if  (cookiesQueue.peek() < k) {
            return -1;
        }
        return res;
    }
}

public class Ex6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
