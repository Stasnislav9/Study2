import java.util.*;

class StudentPrinter{
    public static void printStudents(Set<Student> students, int course){
        boolean found = false;
        for (Student student:students){
            if (student.getCourse() == course){
                System.out.println(student.getName());
                found = true;
            }
        }
    }
}