package QNO45;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;
    private String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name;  // For easier printing
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(1, "Alice", "Computer Science"),
            new Student(2, "Bob", "Mathematics"),
            new Student(3, "Charlie", "Computer Science"),
            new Student(4, "David", "Physics"),
            new Student(5, "Eve", "Mathematics")
        );

        // Group students by department using Streams and Collectors.groupingBy
        Map<String, List<Student>> studentsByDept = students.stream()
            .collect(Collectors.groupingBy(Student::getDepartment));

        // Print departments and student names
        for (Map.Entry<String, List<Student>> entry : studentsByDept.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            entry.getValue().forEach(student -> System.out.println("  " + student.getName()));
        }
    }
}
