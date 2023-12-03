package Tuan9;
import java.util.*;

class NodeEx6 {
    NodeEx6 left;
    NodeEx6 right;
    int data;

    NodeEx6(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Ex6 {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(NodeEx6 root) {
        Queue<NodeEx6> queue = new LinkedList<NodeEx6>();
        if(root==null) return;
        queue.add(root);
        while (!queue.isEmpty()){
            NodeEx6 child = queue.poll();
            if(child!=null){
                System.out.print(child.data+" ");
                queue.add(child.left);
                queue.add(child.right);
            }
        }
    }

    public static NodeEx6 insert(NodeEx6 root, int data) {
        if(root == null) {
            return new NodeEx6(data);
        } else {
            NodeEx6 cur;
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
        NodeEx6 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}