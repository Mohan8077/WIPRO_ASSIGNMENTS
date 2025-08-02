package Assainment1;
//Package structure is assumed to be default or you can add package if needed

abstract class Bank {
 String accNo;
 String custName;
 int custGender; // 1 = Male, 2 = Female
 String custJob;
 double curBal;

 Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
     this.accNo = accNo;
     this.custName = custName;
     this.custGender = custGender;
     this.custJob = custJob;
     this.curBal = curBal;
 }

 public String toString() {
     return "Account No: " + accNo +
             "\nName: " + custName +
             "\nGender: " + (custGender == 1 ? "Male" : "Female") +
             "\nJob: " + custJob +
             "\nCurrent Balance: RM " + curBal;
 }

 public abstract double calcBalance();
}

class Saving extends Bank {
 double savRate; // annual interest rate in percent

 Saving(String accNo, String custName, int custGender, String custJob, double curBal, double savRate) {
     super(accNo, custName, custGender, custJob, curBal);
     this.savRate = savRate;
 }

 @Override
 public double calcBalance() {
     return curBal + (savRate / 100) * curBal;
 }
}

class Current extends Bank {
 boolean fixedDep;
 double curRate;

 Current(String accNo, String custName, int custGender, String custJob, double curBal, double curRate, boolean fixedDep) {
     super(accNo, custName, custGender, custJob, curBal);
     this.curRate = curRate;
     this.fixedDep = fixedDep;
 }

 @Override
 public double calcBalance() {
     double balance = curBal + (curRate / 100) * curBal;
     if (fixedDep) {
         balance -= 150; // service fee
     }
     return balance;
 }
}

public class BankApp {
 public static void main(String[] args) {
     Bank[] customers = new Bank[4];

     customers[0] = new Saving("S001", "Alice", 2, "Teacher", 5000, 3.5);
     customers[1] = new Current("C001", "Bob", 1, "Engineer", 10000, 2.0, true);
     customers[2] = new Current("C002", "Charlie", 1, "Doctor", 8000, 1.8, false);
     customers[3] = new Saving("S002", "Diana", 2, "Designer", 3000, 2.5);

     String searchAccNo = "C001"; // Example search input
     boolean found = false;

     int currentCount = 0;
     double currentTotalBalance = 0;

     for (Bank customer : customers) {
         if (customer instanceof Current) {
             currentCount++;
             currentTotalBalance += customer.calcBalance();
         }

         if (customer.accNo.equals(searchAccNo)) {
             System.out.println("Customer Found:");
             System.out.println(customer);
             System.out.println("Final Balance: RM " + customer.calcBalance());
             found = true;
         }
     }

     if (!found) {
         System.out.println("Customer with account number " + searchAccNo + " not found.");
     }

     System.out.println("\nTotal Current Account Holders: " + currentCount);
     System.out.println("Total Balance of Current Accounts: RM " + currentTotalBalance);
 }
}
