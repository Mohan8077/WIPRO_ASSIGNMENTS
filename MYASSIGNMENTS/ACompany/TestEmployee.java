package ACompany;


public class TestEmployee {
    public static void main(String[] args) {
        try {
            Employee emp1 = new Employee("81-F-112", "Alice", 1960);
            emp1.printDetails();

            System.out.println();

            Employee emp2 = new Employee("79-S-254", "Bob", 1955);
            emp2.printDetails();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}