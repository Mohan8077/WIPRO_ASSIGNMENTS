package Assainment1;

class Vehicle {
    String color;
    int wheels;
    String model;

    // Const
    public Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Color: " + color + ", Wheels: " + wheels);
    }
}

class Truck extends Vehicle {
    public Truck(String color, String model) {
        super(color, 6, model);
    }

    public void carryGoods() {
        System.out.println("Truck is carrying heavy goods.");
    }
}

class Bus extends Vehicle {
    public Bus(String color, String model) {
        super(color, 4, model);
    }

    public void carryPassengers() {
        System.out.println("Bus is carrying passengers.");
    }
}

class Car extends Vehicle {
    public Car(String color, String model) {
        super(color, 4, model);
    }

    public void drive() {
        System.out.println("Car is being driven on the road.");
    }
}

public class Que17 {
    public static void main(String[] args) {
        Truck truck = new Truck("Red", "Volvo-Heavy");
        Bus bus = new Bus("Blue", "Tata-Starbus");
        Car car = new Car("Black", "Honda-City");

        System.out.println("Truck Info:");
        truck.displayInfo();
        truck.carryGoods();

        System.out.println("\nBus Info:");
        bus.displayInfo();
        bus.carryPassengers();

        System.out.println("\nCar Info:");
        car.displayInfo();
        car.drive();
    }
}