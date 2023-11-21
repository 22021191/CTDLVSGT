import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tuan9 {
    public static Map<String,Integer> map = new HashMap<String,Integer>();
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        for(int i=0;i<n;i++){
            String name=input.nextLine();
            int value=input.nextInt();
            map.put(name,value);
        }
        while(input.hasNextLine()){
            String line=input.nextLine();
            if(map.get(line)==null){
                System.out.println("Not found");
            }else {
                System.out.println(line+"="+map.get(line));
            }
        }
    }
}
