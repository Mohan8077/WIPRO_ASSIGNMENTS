package QNO50;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Ravi", "HR", 50000),
            new Employee(102, "Priya", "IT", 60000),
            new Employee(103, "Arun", "HR", 55000),
            new Employee(104, "Kavya", "IT", 70000),
            new Employee(105, "Divya", "Sales", 45000)
        );

        // Q1
        System.out.println("Q1: All employee names:");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        // Q2
        System.out.println("\nQ2: Employees with salary > 55000:");
        employees.stream()
                .filter(e -> e.getSalary() > 55000)
                .forEach(System.out::println);

        // Q3
        long hrCount = employees.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .count();
        System.out.println("\nQ3: HR employee count: " + hrCount);

        // Q4
        System.out.println("\nQ4: Sorted by salary (desc):");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // Q5
        System.out.println("\nQ5: Highest paid employee:");
        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);

        // Q6
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("\nQ6: Average salary: " + avgSalary);

        // Q7
        List<String> namesList = employees.stream()
                .map(Employee::getName)
                .collect(toList());
        System.out.println("\nQ7: All names: " + namesList);

        // Q8
        System.out.println("\nQ8: Group by department:");
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(groupingBy(Employee::getDepartment));
        grouped.forEach((dept, emps) -> {
            System.out.println(dept + " -> " + emps);
        });

        // Q9
        System.out.println("\nQ9: Total salary per department:");
        Map<String, Double> totalPerDept = employees.stream()
                .collect(groupingBy(Employee::getDepartment, summingDouble(Employee::getSalary)));
        totalPerDept.forEach((dept, total) -> {
            System.out.println(dept + " -> " + total);
        });

        // Q10
        System.out.println("\nQ10: IT employee names sorted by salary:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getName)
                .forEach(System.out::println);

        // Q11
        boolean anyLow = employees.stream()
                .anyMatch(e -> e.getSalary() < 40000);
        System.out.println("\nQ11: Any employee with salary < 40000? " + anyLow);

        // Q12
        String nameCsv = employees.stream()
                .map(Employee::getName)
                .collect(joining(", "));
        System.out.println("\nQ12: Comma-separated names: " + nameCsv);

        // Q13
        System.out.println("\nQ13: Top 2 highest earning employees:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(2)
                .forEach(System.out::println);

        // Q14
        System.out.println("\nQ14: Skip first 2 employees:");
        employees.stream()
                .skip(2)
                .forEach(System.out::println);

        // Q15
        System.out.println("\nQ15: First 3 employee names:");
        employees.stream()
                .limit(3)
                .map(Employee::getName)
                .forEach(System.out::println);

        // Q16
        System.out.println("\nQ16: Min salary in HR:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);

        // Q17
        System.out.println("\nQ17: Partition by salary > 55000:");
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(partitioningBy(e -> e.getSalary() > 55000));
        System.out.println("Salary > 55000: " + partitioned.get(true));
        System.out.println("Salary <= 55000: " + partitioned.get(false));

        // Q18
        System.out.println("\nQ18: Map<Department, AvgSalary>:");
        Map<String, Double> avgPerDept = employees.stream()
                .collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));
        avgPerDept.forEach((dept, avg) -> System.out.println(dept + " -> " + avg));

        // Q19
        System.out.println("\nQ19: Sort by name, then salary:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Comparator.comparingDouble(Employee::getSalary)))
                .forEach(System.out::println);

        // Q20
        System.out.println("\nQ20: Convert to Map<Id, Name>:");
        Map<Integer, String> idNameMap = employees.stream()
                .collect(toMap(Employee::getId, Employee::getName));
        idNameMap.forEach((id, name) -> System.out.println(id + " -> " + name));

        // Challenge 1
        System.out.println("\n🔹 Challenge 1: Name starts with D and ends with a:");
        employees.stream()
                .map(Employee::getName)
                .filter(n -> n.startsWith("D") && n.endsWith("a"))
                .forEach(System.out::println);

        // Challenge 2
        System.out.println("\n🔹 Challenge 2: Departments with more than 1 employee:");
        employees.stream()
                .collect(groupingBy(Employee::getDepartment, counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // Challenge 3
        System.out.println("\n🔹 Challenge 3: Second highest salary:");
        employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(s -> System.out.println("Second highest salary: " + s));
    }
}
