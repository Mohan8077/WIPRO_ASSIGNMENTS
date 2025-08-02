package QNO44;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
    }
}

public class EmployeeSortingExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee(101, "Alice", 70000),
            new Employee(102, "Bob", 85000),
            new Employee(103, "Charlie", 70000),
            new Employee(104, "David", 60000)
        ));

        System.out.println("Original list:");
        employees.forEach(System.out::println);

        // Sort by salary descending using Comparator
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // Descending order, so compare e2 to e1
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });

        System.out.println("\nSorted by salary (descending):");
        employees.forEach(System.out::println);

        // Sort by name alphabetically using lambda expression
        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));

        System.out.println("\nSorted by name (alphabetically):");
        employees.forEach(System.out::println);
    }
}
