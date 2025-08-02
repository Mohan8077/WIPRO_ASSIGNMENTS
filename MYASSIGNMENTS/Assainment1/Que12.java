package Assainment1;
import java.util.*;

public class Que12 {

    static class Student {
        private static int rollCounter = 1;

        private int rollNo;
        private String studName;
        private int marksInEng;
        private int marksInMaths;
        private int marksInScience;

        public Student(String studName, int marksInEng, int marksInMaths, int marksInScience) {
            this.rollNo = rollCounter++;
            this.studName = studName;
            this.marksInEng = marksInEng;
            this.marksInMaths = marksInMaths;
            this.marksInScience = marksInScience;
        }

        public int getRollNo() { return rollNo; }
        public String getStudName() { return studName; }
        public int getMarksInEng() { return marksInEng; }
        public int getMarksInMaths() { return marksInMaths; }
        public int getMarksInScience() { return marksInScience; }
        public int getTotalMarks() { return marksInEng + marksInMaths + marksInScience; }
        public double getPercentage() { return getTotalMarks() / 3.0; }
    }

    public static void displayByRollNo(List<Student> students) {
        students.sort(Comparator.comparingInt(Student::getRollNo));
        System.out.println("\n1. Students by Roll No:");
        for (Student s : students) {
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName());
        }
    }

    public static void displayTopPercentage(List<Student> students) {
        Student top = Collections.max(students, Comparator.comparingDouble(Student::getPercentage));
        System.out.println("\n2. Top % Student: Roll No: " + top.getRollNo() + ", Name: " + top.getStudName());
    }

    public static void displayTopMaths(List<Student> students) {
        Student top = Collections.max(students, Comparator.comparingInt(Student::getMarksInMaths));
        System.out.println("\n3. Top in Maths: Roll No: " + top.getRollNo() + ", Name: " + top.getStudName());
    }

    public static void displayMathsScienceSorted(List<Student> students) {
        students.sort(Comparator.comparingInt(s -> s.getMarksInMaths() + s.getMarksInScience()));
        System.out.println("\n4. Sorted by Maths + Science Marks:");
        for (Student s : students) {
            int total = s.getMarksInMaths() + s.getMarksInScience();
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName() + ", Total (Maths+Science): " + total);
        }
    }

    public static void displayWithRanks(List<Student> students) {
        students.sort((s1, s2) -> Integer.compare(s2.getTotalMarks(), s1.getTotalMarks()));
        System.out.println("\n5. Rank List:");
        int rank = 1;
        for (Student s : students) {
            System.out.println("Rank: " + rank + ", Roll No: " + s.getRollNo() + ", Name: " + s.getStudName() +
                    ", Total Marks: " + s.getTotalMarks() + ", Percentage: " + String.format("%.2f", s.getPercentage()));
            rank++;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 85, 90, 88));
        students.add(new Student("Bob", 75, 82, 79));
        students.add(new Student("Charlie", 60, 95, 70));
        students.add(new Student("David", 88, 86, 84));
        students.add(new Student("Eva", 78, 89, 92));
        students.add(new Student("Frank", 90, 91, 89));
        students.add(new Student("Grace", 68, 80, 75));
        students.add(new Student("Helen", 82, 77, 86));

        displayByRollNo(students);
        displayTopPercentage(students);
        displayTopMaths(students);
        displayMathsScienceSorted(students);
        displayWithRanks(students);
    }
}