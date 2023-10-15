package Tuan3;
public class UF {
    private int[] parent;
    private byte[] rank;
    private int count;
    public UF(int n){
        if(n<0) throw new IllegalArgumentException();
        count=n;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public int find(int p){
        while (p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make root of smaller rank point to root of larger rank
        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }
}
