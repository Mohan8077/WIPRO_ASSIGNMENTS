package BCompany;

public class Employee {
 private String employeeId;
 private String name;
 private int yearOfBirth;

 private String designationCode;
 private int year;
 private int number;

 public Employee(String employeeId, String name, int yearOfBirth) throws InvalidEmployeeCode {
     this.employeeId = employeeId;
     this.name = name;
     this.yearOfBirth = yearOfBirth;

     validateAndParseId();
 }

 private void validateAndParseId() throws InvalidEmployeeCode {
     String[] parts = employeeId.split("-");
     if (parts.length != 3) {
         throw new InvalidEmployeeCode("Employee code must be in the format YY-D-XXX");
     }

     try {
         year = Integer.parseInt(parts[0]);
         designationCode = parts[1];
         number = Integer.parseInt(parts[2]);

         if (!(designationCode.equalsIgnoreCase("F") || designationCode.equalsIgnoreCase("S"))) {
             throw new InvalidEmployeeCode("Designation must be 'F' or 'S'");
         }

         if (number < 0 || number > 999) {
             throw new InvalidEmployeeCode("Employee number must be a 3-digit number.");
         }

     } catch (NumberFormatException e) {
         throw new InvalidEmployeeCode("Invalid number format in employee code.");
     }
 }

 public void printDetails() {
     System.out.println("Employee Name      : " + name);
     System.out.println("Employee ID        : " + employeeId);
     System.out.println("Year of Birth      : " + yearOfBirth);
     System.out.println("Joined Year        : " + (1900 + year));
     System.out.println("Designation Code   : " + designationCode);
     System.out.println("Employee Number    : " + number);
 }
}
