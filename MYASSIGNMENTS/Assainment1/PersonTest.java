package Assainment1;
//Abstract class Person
abstract class Person {
 // Abstract methods
 public abstract void eat();
 public abstract void exercise();
}

//Subclass Athlete
class Athlete extends Person {
 @Override
 public void eat() {
     System.out.println("Athlete eats a balanced diet with high protein.");
 }

 @Override
 public void exercise() {
     System.out.println("Athlete exercises daily with intense workouts.");
 }
}

//Subclass LazyPerson
class LazyPerson extends Person {
 @Override
 public void eat() {
     System.out.println("Lazy person eats junk food while watching TV.");
 }

 @Override
 public void exercise() {
     System.out.println("Lazy person rarely exercises and prefers resting.");
 }
}

//Main class to test the program
public class PersonTest {
 public static void main(String[] args) {
     Person athlete = new Athlete();
     Person lazyPerson = new LazyPerson();

     System.out.println("Athlete:");
     athlete.eat();
     athlete.exercise();

     System.out.println("\nLazy Person:");
     lazyPerson.eat();
     lazyPerson.exercise();
 }
}
