package zoo;

import org.animals.*;

public class VandalurZoo {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        Deer deer = new Deer();
        Monkey monkey = new Monkey();
        Elephant elephant = new Elephant();
        Giraffe giraffe = new Giraffe();

        System.out.println("=== Lion ===");
        printAnimalInfo(lion.color, lion.weight, lion.age, lion.isVegetarian(), lion.canClimb(), lion.sound());

        System.out.println("\n=== Tiger ===");
        printAnimalInfo(tiger.color, tiger.weight, tiger.age, tiger.isVegetarian(), tiger.canClimb(), tiger.sound());

        System.out.println("\n=== Deer ===");
        printAnimalInfo(deer.color, deer.weight, deer.age, deer.isVegetarian(), deer.canClimb(), deer.sound());

        System.out.println("\n=== Monkey ===");
        printAnimalInfo(monkey.color, monkey.weight, monkey.age, monkey.isVegetarian(), monkey.canClimb(), monkey.sound());

        System.out.println("\n=== Elephant ===");
        printAnimalInfo(elephant.color, elephant.weight, elephant.age, elephant.isVegetarian(), elephant.canClimb(), elephant.sound());

        System.out.println("\n=== Giraffe ===");
        printAnimalInfo(giraffe.color, giraffe.weight, giraffe.age, giraffe.isVegetarian(), giraffe.canClimb(), giraffe.sound());
    }

    public static void printAnimalInfo(String color, int weight, int age, boolean vegetarian, boolean climbs, String sound) {
        System.out.println("Color: " + color);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Age: " + age + " years");
        System.out.println("Is Vegetarian? " + (vegetarian ? "Yes" : "No"));
        System.out.println("Can Climb? " + (climbs ? "Yes" : "No"));
        System.out.println("Sound: " + sound);
    }
}
