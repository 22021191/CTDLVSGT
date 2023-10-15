package Tuan3;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Scanner;
public class ThreeSum {

    public static void main(String[] args) {
        int count=0;
        int[] array = new int[1000];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<1000; i++){
            int n=sc.nextInt();
            array[i]=n;
        }
        Arrays.sort(array);

        for(int i=0; i<array.length-2; i++){
            for(int k= array.length-1;k>i+1; k--){
                int j=i+1;
                while (j<k){
                    if(array[i]+array[j]+array[k]==0){
                        count++;
                        StdOut.println(array[i]+" "+array[j]+" "+array[k]);
                        break;
                    }
                    if(array[i]+array[j]+array[k]<0){
                        j++;
                    }
                    if(array[i]+array[j]+array[k] >0){
                        break;
                    }

                }

            }
        }
        StdOut.println(count);
    }
}
