package Tuan13;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class CostEx3{
    public int Distance;
    public Node node;
    CostEx3(int distance,Node node) {
        Distance=distance;
        this.node=node;
    }
}
class Node {

    public int Id;

    public List<Node> shortestPath = new LinkedList<>();

    public long distance = 100000;

    public List<CostEx3> adjacentNodes = new ArrayList<>();


    public void addDestination(Node destination, int distance) {
        CostEx3 cost = new CostEx3(distance,destination);
        adjacentNodes.add(cost);

    }

    public Node(int id) {
        this.Id = id;
    }

    // getters and setters
}
class ResultEx3 {


    public static List<Long>shortestReach(int n, List<List<Integer>> edges, int start) {
        List<Node> unsettledNodes = new ArrayList<Node>();
        List<Node> settledNodes=new ArrayList<Node>();
        for (int i=1;i<n+1;i++) {
            Node node=new Node(i);
            unsettledNodes.add(node);
        }
        for (List<Integer> edge:edges){
            int u= edge.get(0)-1;
            int v= edge.get(1)-1;
            int r= edge.get(2);
            unsettledNodes.get(u).addDestination(unsettledNodes.get(v),r);
            unsettledNodes.get(v).addDestination(unsettledNodes.get(u),r);
        }
        unsettledNodes.get(start-1).distance=0;
        while (!unsettledNodes.isEmpty()){
            Node minNode=getMinDistanceNode(unsettledNodes);
            unsettledNodes.remove(minNode);
            settledNodes.add(minNode);

            for (int i=0;i< minNode.adjacentNodes.size();i++){
                Node adj=minNode.adjacentNodes.get(i).node;
                long distance=minNode.distance+minNode.adjacentNodes.get(i).Distance;
                if(!settledNodes.contains(adj)){
                    Update(unsettledNodes,distance,adj.Id);
                }
            }

        }
        List<Long> result=new ArrayList<Long>();
        for(int i=1;i<n+1;i++){
            for (int j=0;j< settledNodes.size();j++){
                if(settledNodes.get(j).Id==i){
                    if(settledNodes.get(j).distance==90000){
                        result.add(-1l);
                    }else if(settledNodes.get(j).distance!=0) {
                        result.add(settledNodes.get(j).distance);
                    }
                    break;
                }
            }

        }
        return result;
    }
    public static void Update(List<Node> unsettledNodes,long distance,int id){

        for (int i=0;i<unsettledNodes.size();i++){
            if(unsettledNodes.get(i).Id==id&&unsettledNodes.get(i).distance>distance){
                unsettledNodes.get(i).distance=distance;

            }
        }
    }
    private static Node getMinDistanceNode(List<Node> unsettledNodes) {
        Node minDistanceNode = null;
        long lowestDistance = 90000;
        for (Node node: unsettledNodes) {
            long nodeDistance = node.distance;
            if (nodeDistance <= lowestDistance) {
                lowestDistance = nodeDistance;
                minDistanceNode = node;
            }
        }
        return minDistanceNode;
    }

}public class Ex3 {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in=new FastReader();
        int t1=in.nextInt();
        for(int gj=0;gj<t1;gj++){
            int n=in.nextInt();
            int m=in.nextInt();
            long w[][]=new long [n+1][n+1];
            for (long[] row: w)
                Arrays.fill(row, 1000000l);
            for(int i=0;i<m;i++){
                int x=in.nextInt(),y=in.nextInt();
                long cmp=in.nextLong();
                if(w[x][y]>cmp){
                    w[x][y]=cmp; w[y][x]=cmp;
                }}
            Stack <Integer> t=new Stack<Integer>();
            int src=in.nextInt();
            for(int i=1;i<=n;i++){
                if(i!=src){t.push(i);}}
            Stack <Integer> p=new Stack<Integer>();
            p.push(src);
            w[src][src]=0;
            while(!t.isEmpty()){int min=989997979,loc=-1;
                for(int i=0;i<t.size();i++){
                    w[src][t.elementAt(i)]=Math.min(w[src][t.elementAt(i)],w[src][p.peek()]+w[p.peek()][t.elementAt(i)]);
                    if(w[src][t.elementAt(i)]<=min){
                        min=(int) w[src][t.elementAt(i)];loc=i;}
                }
                p.push(t.elementAt(loc));t.removeElementAt(loc);}
            for(int i=1;i<=n;i++){
                if(i!=src && w[src][i]!=1000000l){System.out.print(w[src][i]+" ");}
                else if(i!=src){System.out.print("-1"+" ");}
            }System.out.println();
        }
    }
}
