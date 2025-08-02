

package Assainment1;

// Abstract class with abstract methods
abstract class BaseVehicle {
    abstract void startEngine();
    abstract void stopEngine();
}

// Subclass representing a Car
class FourWheeler extends BaseVehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine started.");
    }

    @Override
    void stopEngine() {
        System.out.println("Car engine stopped.");
    }
}

// Subclass representing a Motorcycle
class TwoWheeler extends BaseVehicle {
    @Override
    void startEngine() {
        System.out.println("Motorcycle engine started.");
    }

    @Override
    void stopEngine() {
        System.out.println("Motorcycle engine stopped.");
    }
}

// Main class
public class Motorvehicle {
    public static void main(String[] args) {
        BaseVehicle car = new FourWheeler();
        BaseVehicle motorcycle = new TwoWheeler();

        car.startEngine();
        car.stopEngine();

        motorcycle.startEngine();
        motorcycle.stopEngine();
    }
}
