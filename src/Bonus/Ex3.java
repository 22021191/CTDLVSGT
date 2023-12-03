package Bonus;

import java.util.*;


public class Ex3 {
    public static class NodeEx implements Comparable<NodeEx> {
        public  long id;
        public  Long value;
        public NodeEx(Long id,Long value) {
            this.id = id;
            this.value=value;
        }


        @Override
        public int compareTo(NodeEx otherNode) {
            return Long.compare(this.value, otherNode.value);
        }
    }

    public static Long N;
    public static Long Sum= 0L;

    public static PriorityQueue<NodeEx> queue = new PriorityQueue<NodeEx>();

    public static void RemoveQueue(int tmp){
        while (queue.size()>=tmp){

            NodeEx n = queue.peek();
            Sum-=n.value;
            queue.remove(n);
        }
    }
    public static void quickSort(List<Long> arr) {
        if(arr.size()<=1||arr==null) return;
        Long pivot=arr.get(0);
        List<Long> left=new ArrayList<Long>();
        List<Long> right=new ArrayList<Long>();
        for(int i=1; i<arr.size(); i++) {
            if(arr.get(i) < arr.get(0)){
                left.add(arr.get(i));
            }else {
                right.add(arr.get(i));
            }
        }
        left.add(arr.get(0));
        quickSort(left);
        quickSort(right);
        int index=0;
        for (int i=0; i<left.size(); i++) {
            arr.set(index, left.get(i));
            index++;
        }
        for (int i=0; i<right.size(); i++) {
            arr.set(index, right.get(i));
            index++;
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextLong();
        for(long i=1;i<=N;i++){
            int tmp=scanner.nextInt();
            switch(tmp){
                case 1:
                    Long tmp2=scanner.nextLong();
                    Sum+=tmp2;
                    NodeEx node=new NodeEx(i,tmp2);
                    queue.add(node);
                    break;
                case 2:
                    int tmp3=scanner.nextInt();
                    if(i!=N){
                        if(queue.size()>=tmp3){
                            RemoveQueue(tmp3);
                        }
                    }else {
                        if(queue.size()<tmp3){
                            System.out.println(-1);
                            return;
                        }
                    }
                    break;
            }
        }
        System.out.println(Sum);
        List<Long> indexes=new ArrayList<Long>();
        while (true){
            NodeEx k=queue.peek();
            indexes.add(k.id);
            queue.remove(k);
            if(queue.size()<=0) {
                break;
            }
        }
        quickSort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get((i))+" ");
        }
    }
}
