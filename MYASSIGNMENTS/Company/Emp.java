package Company;
class LowSalException extends Exception {
    public LowSalException(String message) {
        super(message);
    }
}

public class Emp {
    private int empId;
    private String empName;
    private String designation;
    private double basic;
    private final double hra; // read-only after calculation

    // Constructor
    public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
        if (basic < 50000) {
            throw new LowSalException("Basic salary must be at least 50000. Given: " + basic);
        }
        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.basic = basic;
        this.hra = calculateHRA(); // HRA calculated during construction
    }

    // Method to calculate HRA based on designation
    private double calculateHRA() {
        switch (designation.toLowerCase()) {
            case "manager":
                return basic * 0.10;
            case "teamleader":
                return basic * 0.12;
            case "hr":
                return basic * 0.05;
            default:
                return 0.0;
        }
    }

    // Method to print employee details
    public void printDET() {
        System.out.println("Employee ID     : " + empId);
        System.out.println("Employee Name   : " + empName);
        System.out.println("Designation     : " + designation);
        System.out.println("Basic Salary    : " + basic);
        System.out.println("HRA             : " + hra);
    }
}