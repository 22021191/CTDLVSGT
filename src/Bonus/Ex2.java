package Bonus;

import javax.script.Compilable;
import java.util.*;

import static java.lang.Integer.compare;


public class Ex2 {
    public static class Node implements Comparator<Node> {
        public  int id;
        public  int value;
        public Node(int id,int value) {
            this.id = id;
            this.value=value;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return 0;
        }
    }

    public static Long N;
    public static int Sum=0;

    public static PriorityQueue<Node> queue = new PriorityQueue<Node>();

    public static void RemoveQueue(int tmp){
        for(int i=0;i<(queue.size()-tmp+1);i++){
            if(queue.size()!=0) {
                Node temp= queue.peek();
                queue.remove(temp);
                Sum-=temp.value;
                return;

            }else{
                return;
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextLong();
        for(int i=1;i<=N;i++){
            int tmp=scanner.nextInt();
            switch(tmp){
                case 1:
                    int tmp2=scanner.nextInt();
                    Sum+=tmp2;
                    Node node=new Node(i,tmp2);
                    queue.add(node);
                    break;
                case 2:
                    int tmp3=scanner.nextInt();
                    if(i!=N){
                        if(queue.size()>=tmp3){
                            RemoveQueue(tmp3);

                        }
                    }
                    break;
            }
        }
        System.out.println(Sum);

    }
}
