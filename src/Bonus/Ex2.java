package Bonus;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex2 {
    public static int N,K;
    public static long max=0;
        public static PriorityQueue<Long> queue = new PriorityQueue<Long>();
    public static long MAXGT(){
        if(queue.size()>K){
            long tmp= queue.peek();
            queue.remove(tmp);
            return tmp;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        K=scanner.nextInt();
        long[] a=new long[N];
        for(int i=0;i<N;i++){
            a[i]=scanner.nextInt();
            max+=a[i];
            queue.add(a[i]);
            max-=MAXGT();
            System.out.print(max+" ");
        }
    }
}
