package QNO47;
//Custom checked exception
class InvalidSalaryException extends Exception {
 public InvalidSalaryException(String message) {
     super(message);
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

 public double getSalary() {
     return salary;
 }

 // Other getters/setters if needed
 @Override
 public String toString() {
     return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
 }
}

//EmployeeService class
class EmployeeService {

 // Throws exception if salary < 0
 public void validateSalary(double salary) throws InvalidSalaryException {
     if (salary < 0) {
         throw new InvalidSalaryException("Salary cannot be negative: " + salary);
     }
 }

 // Calls validateSalary for the employee's salary
 public void processSalary(Employee emp) throws InvalidSalaryException {
     validateSalary(emp.getSalary());
 }

 // Calls processSalary
 public void startProcess(Employee emp) throws InvalidSalaryException {
     processSalary(emp);
 }
}

//Main class to test
public class Main {
 public static void main(String[] args) {
     Employee emp = new Employee(1, "John Doe", -5000); // negative salary
     EmployeeService service = new EmployeeService();

     try {
         service.startProcess(emp);
         System.out.println("Salary processed successfully.");
     } catch (InvalidSalaryException e) {
         System.err.println("Exception caught: " + e.getMessage());
         e.printStackTrace();
     }
 }
}
