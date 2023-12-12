package Tuan10;

public class Ex4 {
    public static int[] a=new int[10000];
    public static int sz=0;
    public static void inOder(NodeEx1 root){
        if(root==null){
            return;
        }
        inOder(root.left);

        a[sz++]=root.data;

        inOder(root.right);
    }
    boolean checkBST(NodeEx1 root) {
        inOder(root);
        for(int i=1;i<sz-1;i++){
            if(a[i]>a[i+1]){
                return false;
            }
        }
        return true;
    }
}
