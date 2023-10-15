package Tuan3;
import java.util.Scanner;
public class NSum {
    public static void main(String[] args) {
        int count=0;
        int[] array = new int[1000];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<1000; i++){
            int n=sc.nextInt();
            array[i]=n;
        }

        for(int i=0; i<1000; i++){
            count+=Nhieusum(array, i,array[i]);
        }
        System.out.println(count);
    }
    public static int Nhieusum(int[] array,int start,int Sum){
        int count=0;
        int sum=Sum;
        while (start<array.length){

        }
        return count;
    }
}
