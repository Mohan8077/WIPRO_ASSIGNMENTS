package Assainment1;

import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    private int emp_id;
    private String emp_name;
    private transient double emp_sal; // Will not be serialized

    public Employee(int emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    public void display() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Salary: " + emp_sal);
    }
}

public class EmployeeSerializationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get employee details from user
        System.out.print("Enter Employee ID: ");
        int emp_id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String emp_name = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double emp_sal = sc.nextDouble();

        Employee emp = new Employee(emp_id, emp_name, emp_sal);

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            oos.writeObject(emp);
            System.out.println("\nEmployee object has been serialized.");
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            Employee deserializedEmp = (Employee) ois.readObject();
            System.out.println("\nDeserialized Employee object:");
            deserializedEmp.display(); // emp_sal will be 0.0
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }

        sc.close();
    }
}
