package Tuan10;

import java.util.ArrayList;
import java.util.List;

public class IsBst {

    List<Integer> queue=new ArrayList<Integer>();
    void inOrder(Node root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        queue.add(root.data);
        inOrder(root.right);
    }
    boolean checkBST(Node root) {
        inOrder(root);
        for(int i=0;i<queue.size()-1;i++){
            for(int j=i+1;j<queue.size();j++){
                if(queue.get(i)>=queue.get(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
