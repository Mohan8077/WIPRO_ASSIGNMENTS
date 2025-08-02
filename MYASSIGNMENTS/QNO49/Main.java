package QNO49;
import java.util.Optional;

//Custom exception for missing required fields
class MissingFieldException extends Exception {
 public MissingFieldException(String message) {
     super(message);
 }
}

class Employee {
 private int id;
 private String name;
 private Optional<String> email;
 private Optional<String> department;

 public Employee(int id, String name, String email, String department) {
     this.id = id;
     this.name = name;
     this.email = Optional.ofNullable(email);
     this.department = Optional.ofNullable(department);
 }

 // Getters for required fields
 public int getId() { return id; }
 public String getName() { return name; }

 // Optional fields accessors
 public Optional<String> getEmail() {
     return email;
 }

 public Optional<String> getDepartment() {
     return department;
 }

 // Return email or default value if absent
 public String getEmailOrDefault() {
     return email.orElse("noemail@company.com");
 }

 // Return department or default value if absent
 public String getDepartmentOrDefault() {
     return department.orElse("General");
 }

 // Throw custom exception if email is missing
 public String getEmailOrThrow() throws MissingFieldException {
     return email.orElseThrow(() -> new MissingFieldException("Email is missing for employee: " + name));
 }

 // Throw custom exception if department is missing
 public String getDepartmentOrThrow() throws MissingFieldException {
     return department.orElseThrow(() -> new MissingFieldException("Department is missing for employee: " + name));
 }

 @Override
 public String toString() {
     return "Employee{id=" + id + ", name='" + name + "', email=" + email.orElse("N/A") +
            ", department=" + department.orElse("N/A") + "}";
 }
}

public class Main {
 public static void main(String[] args) {
     Employee emp1 = new Employee(1, "Alice", "alice@example.com", "IT");
     Employee emp2 = new Employee(2, "Bob", null, null);

     // Safely accessing optional fields with default values
     System.out.println(emp1.getName() + "'s email: " + emp1.getEmailOrDefault());
     System.out.println(emp2.getName() + "'s email: " + emp2.getEmailOrDefault());

     System.out.println(emp1.getName() + "'s department: " + emp1.getDepartmentOrDefault());
     System.out.println(emp2.getName() + "'s department: " + emp2.getDepartmentOrDefault());

     // Using orElseThrow to throw custom exception for required data
     try {
         System.out.println(emp1.getName() + "'s email: " + emp1.getEmailOrThrow());
         System.out.println(emp2.getName() + "'s email: " + emp2.getEmailOrThrow());
     } catch (MissingFieldException e) {
         System.err.println("Exception: " + e.getMessage());
     }

     try {
         System.out.println(emp1.getName() + "'s department: " + emp1.getDepartmentOrThrow());
         System.out.println(emp2.getName() + "'s department: " + emp2.getDepartmentOrThrow());
     } catch (MissingFieldException e) {
         System.err.println("Exception: " + e.getMessage());
     }
 }
}
