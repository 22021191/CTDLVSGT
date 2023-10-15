package Tuan4;

public class NSum {
    public static int Find(int[] array, int start,int count,int sum){
        sum+=array[start];
        if(sum==0) count++;
        if(start==array.length) return count;
        for(int i=start+1;i<array.length;i++){
            int tmp=Find(array,i,0,sum);
            count+=tmp;
        }
        System.out.println("end "+count);
        return count;
    }
    public static void main(String[] args){
        int count=0;
        int array[]={ -2,2,-1,0, 1};
        for(int i=0;i<array.length;i++){
            int sum=0;
            count+=Find(array,i,0,0);
        }
        System.out.println(count);
    }
}
