import java.util.Scanner;
public class _Selection_Sort {
    public static int Min(int i,int a[],int n){
        int result=a[i];
        for(int j=i;j<n;j++){
            if(a[j]<result){
                result=a[j];
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] a=new int[1000];
        int n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int[] result=new int[n];
        for (int i=0;i<n;i++){
            result[i]=Min(i,a,n);
        }
    }
}
