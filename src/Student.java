import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;


    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }


    public void setCourse(int course) {
        this.course = course;
    }


    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }


    public Integer getGrade(String subject) {
        return grades.get(subject);
    }


    public Set<String> getSubjects() {
        return grades.keySet();
    }


    public double getAverageGrade() {
        double sum = 0.0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Для красивого вывода
    @Override
    public String toString() {
        return String.format("Студент: %s, Группа: %s, Курс: %d, Средний балл: %.2f",
                name, group, course, getAverageGrade());
    }
}