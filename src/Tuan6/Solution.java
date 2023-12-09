package Tuan6;

import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
 class Student implements Comparable<Student> {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student o) {
        if(this.getCgpa()==o.getCgpa()){
            if(this.getName().equals(o.getName())){
                return Integer.compare( o.getId(),this.getId());
            }else {
                return Character.compare(o.getName().charAt(0),this.getName().charAt(0));
            }
        }else {
            return Double.compare(this.getCgpa(),o.getCgpa());
        }
    }

}
 class Priorities{
    public Priorities() {
    }

    static PriorityQueue<Student> queue=new PriorityQueue<Student>(Collections.reverseOrder());
    public static List<Student> getStudents(List<String> events) {
        for (String event : events) {
            String[] words = event.split("\\s");
            switch (words[0]){
                case "ENTER":
                    Student student=new Student(Integer.parseInt(words[3]), words[1], Double.parseDouble(words[2]));
                    queue.add(student);
                    break;
                case "SERVED":
                    Student s=queue.poll();
                    break;
            }
        }
        List<Student> students = new ArrayList<Student>();
        while (!queue.isEmpty()){
            students.add(queue.poll());
        }
        return students;
    }
}
public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
