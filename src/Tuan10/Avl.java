package Tuan10;

class Node{
    int val;
    int ht;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
    Node(){

    }
}
public class Avl {
    static Node insert(Node root,int val) {
        if (root == null) {
            root=new Node();
            root.val=val;
            root.ht = 0;
            root.left = null;
            root.right = null;
            return root;
        }
        if(val > root.val)  {
            root.right = insert(root.right, val);
        }
        else if (val < root.val){
            root.left  = insert(root.left, val);
        }
        else {
            return root;
        }

        root.ht=getHeight(root);

        if (getHeight(root.left) - getHeight(root.right) > 1) {
            if (getHeight(root.left.left) - getHeight(root.left.right) >= 0) {
                return rotateR(root);
            } else {
                root.left = rotateL(root.left);
                return rotateR(root);
            }


        } else if (getHeight(root.left) - getHeight(root.right) < -1) {
            if (getHeight(root.right.left) - getHeight(root.right.right) <= 0) {
                return rotateL(root);
            } else {
                root.right = rotateR(root.right);
                return rotateL(root);
            }
        }


        return root;
    }

    static Node rotateR(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.ht = getHeight(root);
        newRoot.ht = getHeight(newRoot);
        return newRoot;
    }

    static Node rotateL(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.ht = getHeight(root);
        newRoot.ht = getHeight(newRoot);
        return newRoot;
    }

    static int getHeight(Node x) {
        if (x == null) return -1;
        return Math.max(getHeight(x.left), getHeight(x.right))+1;
    }

}
