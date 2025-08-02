package Assainment1;

public class Que2 {

	public static void main(String[] args) 
	{
		int totalStudents = 90;
		int totalBoys = 45;
		
		int totalGradeA = totalStudents * 50 / 100;  // 50% of 90 = 45
		int boysWithGradeA = 20;
		
		int girlsWithGradeA = totalGradeA - boysWithGradeA;
		
		System.out.println("Total number of girls getting grade A: " + girlsWithGradeA);
		
	}

}
