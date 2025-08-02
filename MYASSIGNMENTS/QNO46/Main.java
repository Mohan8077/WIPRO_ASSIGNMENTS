package QNO46;
import java.util.*;

//Generic Repository class
class Repository<T, ID> {
 private Map<ID, T> storage = new HashMap<>();

 public void save(ID id, T entity) {
     storage.put(id, entity);
 }

 public T findById(ID id) {
     return storage.get(id);
 }

 public List<T> findAll() {
     return new ArrayList<>(storage.values());
 }

 public void deleteById(ID id) {
     storage.remove(id);
 }
}

//Employee class
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
     return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
 }
}

public class Main {
 public static void main(String[] args) {
     // Instantiate Repository for Employee with Integer IDs
     Repository<Employee, Integer> employeeRepo = new Repository<>();

     // Add 3 employees
     employeeRepo.save(1, new Employee(1, "Alice", 75000));
     employeeRepo.save(2, new Employee(2, "Bob", 82000));
     employeeRepo.save(3, new Employee(3, "Charlie", 60000));

     // Retrieve and print all employees
     System.out.println("All Employees:");
     employeeRepo.findAll().forEach(System.out::println);

     // Retrieve a specific employee by ID
     System.out.println("\nEmployee with ID 2:");
     System.out.println(employeeRepo.findById(2));

     // Delete an employee by ID
     employeeRepo.deleteById(1);

     // Print remaining employees
     System.out.println("\nEmployees after deleting ID 1:");
     employeeRepo.findAll().forEach(System.out::println);
 }
}
