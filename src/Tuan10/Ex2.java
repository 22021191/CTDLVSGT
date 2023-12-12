package Tuan10;
import java.util.*;

public class Ex2 {

        public static void preOrder( NodeEx1 root ) {

            if( root == null)
                return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

        }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

        public static NodeEx1 insert(NodeEx1 root, int data) {
            if(root==null){
                return new NodeEx1(data);
            }
           else{
               NodeEx1 current;
               if(root.data>data){
                   current= insert(root.left,data);
                   root.left=current;
               }else {
                   current= insert(root.right,data);
                   root.right=current;
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
            scan.close();
            preOrder(root);
        }

}
