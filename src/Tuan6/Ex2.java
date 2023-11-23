package Tuan6;

import java.util.List;

public class Ex2 {
    public static void SelectinSort(int n, List<Integer> arr){
        for (int i = 0;i<n;i++){
            int i_min=i;
            int V_min=arr.get(i);
            for (int j =i;j<n;j++){
                if(arr.get(j)<V_min){
                    V_min=arr.get(j);
                    i_min=j;
                }
            }
            int temp=arr.get(i);
            arr.set(i,V_min);
            arr.set(i_min,temp);
        }
    }
}
