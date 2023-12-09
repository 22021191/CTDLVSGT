package Tuan6;

import java.util.*;

public class Ex4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<StudentEx6> studentList = new ArrayList<StudentEx6>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            StudentEx6 st = new StudentEx6(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, new Comparator<StudentEx6>(){
            @Override
            public int compare(StudentEx6 x, StudentEx6 y)
            {
                if (x.getCgpa() != y.getCgpa()){
                    return Double.compare(y.getCgpa(), x.getCgpa());
                }
                else if(!(x.getFname().equals(y.getFname())))
                    return x.getFname().compareTo(y.getFname());
                else
                    return x.getId()-y.getId();
            }
        });
        for(StudentEx6 st: studentList){
            System.out.println(st.getFname());
        }
    }
}
