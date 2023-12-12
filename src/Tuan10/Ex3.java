package Tuan10;
import java.util.*;

public class Ex3 {

    public static NodeEx1 lca(NodeEx1 root, int v1, int v2) {
        // Write your code here.
        if(root.data>Math.max(v1,v2)){
                return lca(root.left,v1,v2);
        }else if(root.data<Math.min(v1,v2)){
                return lca(root.right,v1,v2);
        }
        return root;
    }

    public static NodeEx1 insert(NodeEx1 root, int data) {
        if(root == null) {
            return new NodeEx1(data);
        } else {
            NodeEx1 cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        NodeEx1 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        NodeEx1 ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }

}
