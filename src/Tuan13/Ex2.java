package Tuan13;
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


class Cost implements Comparable<Cost>
{
    public int r, v;
    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }
    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r> c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }

}
class Result {


    public static int prims(int n, List<List<Integer>> edges, int start) {
        List<List<Cost>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge:edges){
            int u= edge.get(0);
            int v= edge.get(1);
            int r= edge.get(2);
            adj.get(u).add(new Cost(r,v) );
            adj.get(v).add(new Cost(r,u));
        }
        PriorityQueue<Cost> costQueue = new PriorityQueue<Cost>();
        for(int i=0;i<adj.get(start).size();i++){
            costQueue.add(adj.get(start).get(i));
        }
        boolean[] visit=new boolean[n+1];
        for(int i=0;i<n;i++){
            visit[i] = false;
        }
        visit[start]=true;
        int sum=0,count=1;
        while (count<n){
            Cost tmp=costQueue.poll();
            if(!visit[tmp.v]){
                for(int i=0;i<adj.get(tmp.v).size();i++){
                    costQueue.add(adj.get(tmp.v).get(i));
                }
                visit[tmp.v] =true;
                count++;
                sum += tmp.r;
            }
        }
        return sum;
    }

}

public class Ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
