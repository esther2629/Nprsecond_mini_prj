import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String name;
    int mark;

    Student(int id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public String toString() {
        return id + " - " + name + " - " + mark;
    }
}

public class Main {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student(101, "John", 85),
            new Student(102, "David", 65),
            new Student(103, "Sam", 45),
            new Student(104, "Ravi", 90)
        );

        // 1. Display all students - forEach + Method Reference
        System.out.println("All Students:");
        students.forEach(System.out::println);

        // 2. Students who passed - Stream + Lambda + Collectors
        List<Student> passed = students.stream()
                .filter(s -> s.mark >= 50)
                .collect(Collectors.toList());

        System.out.println("\nPassed Students:");
        passed.forEach(System.out::println);

        // 3. Search student - Optional
        String searchName = "Ravi";

        Optional<Student> result = students.stream()
                .filter(s -> s.name.equalsIgnoreCase(searchName))
                .findFirst();

        System.out.println("\nSearch Result:");
        System.out.println(
                result.map(Student::toString)
                      .orElse("Student Not Found")
        );

        // 4. Average mark - Stream
        double average = students.stream()
                .mapToInt(s -> s.mark)
                .average()
                .orElse(0);

        System.out.println("\nAverage Mark: " + average);
    }
}