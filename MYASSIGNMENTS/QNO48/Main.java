package QNO48;
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

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", 70000),
            new Employee(2, "Bob", 85000),
            new Employee(3, "Charlie", 60000)
        );

        // Print Name and Salary
        EmployeeProcessor printNameSalary = e -> 
            System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());

        // Print Bonus (10% of salary)
        EmployeeProcessor printBonus = e -> {
            double bonus = e.getSalary() * 0.10;
            System.out.println("Bonus for " + e.getName() + ": " + bonus);
        };

        System.out.println("=== Employee Name and Salary ===");
        employees.forEach(printNameSalary::process);

        System.out.println("\n=== Employee Bonus (10%) ===");
        employees.forEach(printBonus::process);
    }
}
