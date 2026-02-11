import java.util.*;

public class Main {
    public static void main (String[] args) {

        StudentManager manager = new StudentManager();

        Student student1 = new Student("Баскаков Станислав", "А", 1);
        student1.addGrade("Математика", 5);
        student1.addGrade("Физика", 4);
        student1.addGrade("Программирование", 5);
        manager.addStudent(student1);

        Student student2 = new Student("Петр Петров", "Б", 2);
        student2.addGrade("Математика", 3);
        student2.addGrade("Физика", 2);
        student2.addGrade("История", 2);
        manager.addStudent(student2);

        Student student3 = new Student("Иван Иванов", "В", 4);
        student3.addGrade("Математика", 4);
        student3.addGrade("Физика", 4);
        student3.addGrade("Английский", 5);
        manager.addStudent(student3);

        Student student4 = new Student("Алексей Алексеев", "Г", 3);
        student4.addGrade("Математика", 5);
        student4.addGrade("Физика", 5);
        student4.addGrade("Программирование", 5);
        manager.addStudent(student4);

        System.out.println("\n ВСЕ СТУДЕНТЫ ДО ИЗМЕНЕНИЙ");
        manager.printAllStudents();

        Set<Student> studentSet = new HashSet<>(manager.getAllStudents());

        System.out.println("\nСтуденты 1 курса:");
        StudentPrinter.printStudents(studentSet, 1);

        System.out.println("\nСтуденты 2 курса:");
        StudentPrinter.printStudents(studentSet, 2);

        System.out.println("\nСтуденты 3 курса:");
        StudentPrinter.printStudents(studentSet, 3);

        System.out.println("\nСтуденты 4 курса:");
        StudentPrinter.printStudents(studentSet, 4);

        System.out.println("\n УДАЛЯЕМ СТУДЕНТОВ СО СРЕДНИМ БАЛЛОМ < 3 ");
        manager.removeStudents();
        System.out.println("После удаления осталось: " + manager.getStudentCount() + " студентов");

        System.out.println("\n ПЕРЕВОДИМ СТУДЕНТОВ НА СЛЕДУЮЩИЙ КУРС");
        manager.promoteStudents();

        System.out.println("\n ИТОГОВЫЙ РЕЗУЛЬТАТ");
        manager.printAllStudents();

        System.out.println("\n ПРОВЕРКА ПО КУРСАМ ПОСЛЕ ИЗМЕНЕНИЙ ");

        Set<Student> finalSet = new HashSet<>(manager.getAllStudents());

        System.out.println("\nСтуденты 1 курса (после изменений):");
        StudentPrinter.printStudents(finalSet, 1);

        System.out.println("\nСтуденты 2 курса (после изменений):");
        StudentPrinter.printStudents(finalSet, 2);

        System.out.println("\nСтуденты 3 курса (после изменений):");
        StudentPrinter.printStudents(finalSet, 3);

        System.out.println("\nСтуденты 4 курса (после изменений):");
        StudentPrinter.printStudents(finalSet, 4);


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7-999-111-22-33");
        phoneBook.add("Петров", "+7-999-222-33-44");
        phoneBook.add("Сидоров", "+7-999-333-44-55");
        phoneBook.add("Иванов", "+7-999-444-55-66");

        phoneBook.printAll();

        System.out.println("Поиск 'Иванов': " + phoneBook.get("Иванов"));
        System.out.println("Поиск 'Петров': " + phoneBook.get("Петров"));
        System.out.println("Поиск 'Сидоров': " + phoneBook.get("Сидоров"));
    }

}
