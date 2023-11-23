package Tuan5;

import java.io.*;
import java.util.*;

public class Ex3 {

    public static int[] queue=new int[1000];
    public static int top=-1;
    public static int bot=0;
    public static void Enqueue(int[] a,int i){
        queue[++top]=i;
    }
    public static int Dequeue(){
        return queue[bot++];
    }
    public static void Print(){
        System.out.print(bot);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        int rear=-1;
        int front=0;
        for(int i=0;i<n;i++)
        {

            int ops=in.nextInt();
            if(ops ==1)
            {
                int num=in.nextInt();
                arr[++rear]=num;
            }
            else if (ops==2)
            {
                int num=arr[front++];
            }
            else
            {
                System.out.println(arr[front]);
            }
        }
    }
}

