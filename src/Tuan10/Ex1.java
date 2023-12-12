package Tuan10;

import java.util.*;

class NodeEx1 {
    NodeEx1 left;
    NodeEx1 right;
    int data;

    NodeEx1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Tuan10.Node
        int data;
        Tuan10.Node left;
        Tuan10.Node right;
    */
    public static int height(NodeEx1 root) {
        if(root==null) return -1;
        int heightLeft=height(root.left);
        int heightRight=height(root.right);
        return Math.max(heightLeft, heightRight)+1;
        // Write your code here.
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
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}

