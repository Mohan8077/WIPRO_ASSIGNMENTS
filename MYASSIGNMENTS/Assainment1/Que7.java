package Assainment1;
import java.util.Scanner;

public class Que7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of classes held: ");
        int classesHeld = sc.nextInt();

        System.out.print("Enter number of classes attended: ");
        int classesAttended = sc.nextInt();

        double attendancePercentage = (classesAttended * 100.0) / classesHeld;
        System.out.println("Attendance Percentage: " + attendancePercentage + "%");

        if (attendancePercentage >= 70) {
            System.out.println("Allowed to sit in exam.");
        } else {
            System.out.print("Do you have a medical cause? (Y/N): ");
            char medical = sc.next().charAt(0);

            if (medical == 'Y' || medical == 'y') {
                System.out.println("Allowed to sit in exam due to medical cause.");
            } else {
                System.out.println("Not allowed to sit in exam.");
            }
        }

        sc.close();
    }
}