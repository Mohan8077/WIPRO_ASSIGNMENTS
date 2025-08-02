package house;

import house.Hall;
import house.Kitchen;

public class HouseTest {
    public static void main(String[] args) {
        Hall hall = new Hall();
        hall.showMessage();

        System.out.println();

        Kitchen kitchen = new Kitchen();
        kitchen.showAppliances();
    }
}
