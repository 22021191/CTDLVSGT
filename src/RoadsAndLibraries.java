
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Result {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] visited;

    long count = 0;

    public Result(List<List<Integer>> adj, int n) {
        visited = new boolean[9999999];
        this.adj = adj;
        for(int i = 1; i < n+1; i++){
            if(!visited[i]){
                dfs(i,adj);
                count++;
            }
        }
    }

    private void dfs(int i, List<List<Integer>> adj) {
        visited[i] = true;
        for(int w : adj.get(i)){
            if(!visited[w]){
                dfs(w,adj);
            }
        }
    }
}
public class RoadsAndLibraries {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        for(int i = 0; i < q; i++){
            List<List<Integer>> adj = new ArrayList<>();
            long n = input.nextLong();
            long m = input.nextLong();
            int c_lib = input.nextInt();
            int c_road = input.nextInt();
            if(m == 0){
                System.out.println(n*c_lib);
                continue;
            }
            for(int k = 0; k <= n; k++){
                List<Integer> tmp = new ArrayList<>();
                adj.add(tmp);
            }

            for(int j = 0; j < m; j++){
                int v = input.nextInt();
                int w = input.nextInt();
                adj.get(v).add(w);
                adj.get(w).add(v);
            }
            Result ans = new Result(adj,(int)n);
            long cost = (c_road*(n-ans.count)+c_lib* ans.count);

            if((long) n *c_lib>cost){
                System.out.println(cost);
            } else{
                System.out.println(n*c_lib);
            }
        }

    }
}