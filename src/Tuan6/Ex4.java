package Tuan6;

import java.util.*;

public class Ex4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, new Comparator<Student>(){
            @Override
            public int compare(Student x, Student y)
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
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}
