package Assainment1;

public class Assainment1 
{
	public static void methodWithoutAssignmentOps() {
        int number = 2345;
        number = number + 8;           
        number = number / 3;           
        number = number % 5;           
        number = number * 5;          
        System.out.println("Without assignment operators: " + number);
    }

    public static void methodWithAssignmentOps() {
        int number = 2345;
        number += 8;     
        number /= 3;     
        number %= 5;     
        number *= 5;     
        System.out.println("With assignment operators: " + number);
    }

    public static void main(String[] args) {
        methodWithoutAssignmentOps();
        methodWithAssignmentOps();
    }

}
