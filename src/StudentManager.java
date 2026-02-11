import java.util.*;

class StudentManager {
    private List<Student> students;

    public StudentManager(){
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudents() {

        List<Student> goodStudents = new ArrayList<>();


        for (Student student:students) {
            double average = student.getAverageGrade();
            if (average >= 3.0){
                goodStudents.add(student);
            }

        }
        students = goodStudents;
    }

    public void promoteStudents(){

        for (Student student:students){
            if (student.getAverageGrade() >= 3.0){
                int oldCourse = student.getCourse();
                student.setCourse(oldCourse + 1);
            }
        }
    }

    public List<Student> getAllStudents(){
        return new ArrayList<>(students);
    }

    public void printAllStudents(){
        for (int i =0; i < students.size(); i++){
            Student s = students.get(i);
            System.out.println((i + 1) + ". " + s.getName() +
                    ", группа " + s.getGroup() +
                    ", курс " + s.getCourse() +
                    ", средний балл: " + String.format("%.2f", s.getAverageGrade()));
        }
    }

    public int getStudentCount() {
        return students.size();
    }


}
