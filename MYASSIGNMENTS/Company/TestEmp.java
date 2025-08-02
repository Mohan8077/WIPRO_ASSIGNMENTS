package Company;

public class TestEmp {
    public static void main(String[] args) {
        try {
            Emp emp1 = new Emp(101, "Alice", "Manager", 60000);
            emp1.printDET();

            System.out.println();

            Emp emp2 = new Emp(102, "Bob", "HR", 48000); // This will throw LowSalException
            emp2.printDET();

        } catch (LowSalException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}