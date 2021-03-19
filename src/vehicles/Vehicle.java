package vehicles;
import java.util.Random;

public abstract class Vehicle {
    //Defines the amount of wheels that the vehicle has
    private int wheels;
    //Defines the id number
    private int id;

    public Vehicle(int wheels, int id) {
        this.wheels = wheels;
        this.id = id;
    }

    //Getter method for wheels var
    public int getWheels() {
        return wheels;
    }

    //Setter method for wheels var
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    //Getter method for Id
    public int getId() {
        return this.id;
    }

    //Setter method for Id
    public void setId(int idList[]) {
        Random rand = new Random();
        int num = 999 + rand.nextInt(9001);
        this.id = num;
    }
}
