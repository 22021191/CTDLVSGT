package Bonus;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Ex1 {
    static PriorityQueue<Long> LittleQueue = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Long> BigQueue = new PriorityQueue<Long>();
    public static void addStudent(Long a){
        if(BigQueue.isEmpty()||a>BigQueue.peek()){
            BigQueue.add(a);
        }else {
            LittleQueue.add(a);
        }
        if(BigQueue.size()-LittleQueue.size()>1){
            LittleQueue.add(BigQueue.poll());
        }else if(LittleQueue.size()-BigQueue.size()>1){
            BigQueue.add(LittleQueue.poll());
        }
    }
    public static Long removeStudent(){
        if(BigQueue.isEmpty()&&LittleQueue.isEmpty()){
            return 0l;
        }
        if(BigQueue.size()==LittleQueue.size()){
            return LittleQueue.poll();
        }else {
            if(BigQueue.size()>LittleQueue.size()){
                return BigQueue.poll();
            }else {
                return LittleQueue.poll();
            }
        }
    }
    public static Long Media(){
        if(BigQueue.isEmpty()&&LittleQueue.isEmpty()){
            return 0l;
        }
        if(BigQueue.size()==LittleQueue.size()){
            return LittleQueue.peek();
        }else {
            if(BigQueue.size()>LittleQueue.size()){
                return BigQueue.peek();
            }else {
                return LittleQueue.peek();
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        for (int i=0;i<N;i++){
            long j=scanner.nextLong();
            addStudent(j);
        }
        for(int i=1;i<=M;i++){
            int tmp=scanner.nextInt();
            switch(tmp){
                case 1:
                    Long tmp2=scanner.nextLong();
                    addStudent(tmp2);
                    break;
                case 2:
                    long tmp3=removeStudent();
                    break;
                case 3:
                    long tmp4=Media();
                    System.out.println(tmp4);
                    break;
            }
        }
    }
}
