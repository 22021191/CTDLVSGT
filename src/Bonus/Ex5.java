package Bonus;
import java.util.*;

public class Ex5 {

    public static List<Long> A=new ArrayList<>();
    public  static long[] tree;
    public static void MakeSegmentTree(List<Long> arr, int id, int start, int end) {
        if(start==end){
            tree[id]=arr.get(start);
        }else {
            int mid = (start + end)/2;
            MakeSegmentTree(arr, 2*id + 1, start, mid);
            MakeSegmentTree(arr, 2*id + 2, mid + 1, end);
            tree[id] = Math.min(tree[2*id + 1] , tree[2*id + 2]);
        }
    }
    public static long MinLR(int node, int start, int end, int l, int r){
        if(r < start || end < l){
            return Long.MAX_VALUE;
        }
        if(l <= start && end <= r){
            return tree[node];
        }
        int mid = (start + end)/2;
        long p1 = MinLR(2*node + 1, start, mid, l, r);
        long p2 = MinLR(2*node + 2, mid + 1, end, l, r);
        return Math.min(p1, p2);
    }
    public static void Update(int node, int start, int end, int id, long v){
        if(id < start || end < id){
            return ;
        }
        if(start==end){
            tree[node]=v;
            return;
        }
        int mid = (start + end)/2;
        Update(2*node + 1, start, mid, id, v);
        Update(2*node + 2, mid + 1, end, id, v);
        tree[node]=Math.min(tree[node*2+2], tree[node*2 + 1]);

    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        for (int i=0; i<N; i++) {
            long j=scanner.nextLong();
            A.add(j);
        }
        tree=new long[N*4];
        for (int i=0;i<tree.length;i++){
            tree[i]=Long.MAX_VALUE;
        }
        MakeSegmentTree(A,0,0,N-1);
        int q=scanner.nextInt();
        for (int i=0; i<q; i++) {
            int event=scanner.nextInt();
            switch (event){
                case 1:
                    int l=scanner.nextInt();
                    int r=scanner.nextInt();
                    System.out.println(MinLR(0,0,N-1,l-1,r-1));
                    break;
                case 2:
                    int Id= scanner.nextInt();
                    long v=scanner.nextLong();
                    Update(0,0,N-1,Id-1,v);
            }

        }
    }

}