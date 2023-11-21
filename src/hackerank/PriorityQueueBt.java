package hackerank;

import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueBt {
    public static int cookies(int k, List<Integer> A) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i<A.size(); i++) {
            queue.add(A.get(i));
        }
        while (true){
            int x=queue.peek();
            queue.remove(x);
            if(x>k){
                return count;
            }else {
                if(queue.size()==0){
                    return -1;
                }else{
                    int y=queue.peek();
                    queue.remove(y);
                    if(y>k){
                        return ++count;
                    }else{
                        if(queue.size()==0){
                            return -1;
                        }
                        queue.add(x+2*y);
                    }
                }
            }
            count++;
        }

    }
}
