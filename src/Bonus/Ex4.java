package Bonus;

import java.util.*;

public class Ex4 {

    public static List<Integer> A=new ArrayList<>();
    public  static int[] tree;
    public static void MakeSegmentTree(List<Integer> arr, int id, int start, int end) {
        if(start==end){
            tree[id]=arr.get(start);
        }else {
            int mid = (start + end)/2;
            MakeSegmentTree(arr, 2*id + 1, start, mid);
            MakeSegmentTree(arr, 2*id + 2, mid + 1, end);
            tree[id] = Math.max(tree[2*id + 1] , tree[2*id + 2]);
        }
    }
    public static long MaxLR(int node, int start, int end, int l, int r){
        if(r < start || end < l){
            return 0;
        }
        if(l <= start && end <= r){
            return tree[node];
        }
        int mid = (start + end)/2;
        long p1 = MaxLR(2*node + 1, start, mid, l, r);
        long p2 = MaxLR(2*node + 2, mid + 1, end, l, r);
        return Math.max(p1, p2);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        for (int i=0; i<N; i++) {
            int j=scanner.nextInt();
            A.add(j);
        }
        tree=new int[N*4];
        MakeSegmentTree(A,0,0,N-1);
        int q=scanner.nextInt();
        for (int i=0; i<q; i++) {
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            System.out.println(MaxLR(0,0,N-1,l-1,r-1));
        }
    }

}