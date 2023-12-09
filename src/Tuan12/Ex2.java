package Tuan12;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static List<Integer> bfs(int n,List<List<Integer>> graph, int s) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n+1; i++) {
            result.add(-1);
        }

        boolean[] visist=new boolean[n+1];
        visist[0]=true;
        visist[s]=true;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            int current=queue.poll();

            for (int i=0;i<n+1;i++){
                if(!visist[i] && graph.get(current).get(i)>0){
                    queue.add(i);
                    visist[i]=true;
                    if(result.get(current)==-1){
                        result.set(i,6);
                    }else {
                        result.set(i,graph.get(current).get(i)+result.get(current));
                    }
                }

            }
        }
        result.remove(s);
        result.remove(0);
        return result;
    }

}
 class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                List<Integer> v = new ArrayList<>();
               for (int j = 0; j <= N; j++) {
                   v.add(0);
               }
                graph.add(v);
            }
            for (int i = 0; i < M; i++) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).set(n2,6);
                graph.get(n2).set(n1,6);
            }
            start = scanner.nextInt();
            List<Integer> costs = Result.bfs(N,graph, start);
            for (int i = 0; i < costs.size(); i++) {
                System.out.print(costs.get(i) + " ");
            }
            System.out.println();
        }
    }
}
