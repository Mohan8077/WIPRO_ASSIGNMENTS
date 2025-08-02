package ACompany;

public class Employee {
    private String employeeId;
    private String name;
    private int yearOfBirth;

    private String designationCode;
    private int year;
    private int number;

    // Constructor
    public Employee(String employeeId, String name, int yearOfBirth) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;

        parseEmployeeId();
    }

    // Method to parse employeeId into components
    private void parseEmployeeId() {
        try {
            String[] parts = employeeId.split("-");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid Employee ID format. Expected format: YY-D-XXX");
            }

            this.year = Integer.parseInt(parts[0]);
            this.designationCode = parts[1];

            if (!designationCode.equalsIgnoreCase("F") && !designationCode.equalsIgnoreCase("S")) {
                throw new IllegalArgumentException("Invalid designation code. Must be 'F' or 'S'");
            }

            this.number = Integer.parseInt(parts[2]);

            if (number < 0 || number > 999) {
                throw new IllegalArgumentException("Employee number must be a 3-digit number.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in Employee ID.");
        }
    }

    // Method to display employee details
    public void printDetails() {
        System.out.println("Employee Name      : " + name);
        System.out.println("Employee ID        : " + employeeId);
        System.out.println("Year of Birth      : " + yearOfBirth);
        System.out.println("Joined Year (from ID)  : " + (1900 + year));
        System.out.println("Designation Code   : " + designationCode);
        System.out.println("Employee Number    : " + number);
    }
}
