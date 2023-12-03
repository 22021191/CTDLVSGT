package Tuan9;
//Complete this code or write your own from scratch
import java.util.*;


class Ex2{
    public static void main(String[] args){
        Map<String,String> people = new HashMap();

        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        input.nextLine();
        for(int i=0;i<n;i++){
            String name=input.nextLine();
            String phone=input.nextLine();
            people.put(name, phone);
        }

        while(input.hasNextLine()){
            String s=input.nextLine();
            if (people.containsKey(s)) System.out.println(s + "=" + people.get(s));
            else System.out.println("Not found");
        }

    }
}









