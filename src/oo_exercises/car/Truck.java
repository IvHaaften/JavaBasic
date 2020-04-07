package oo_exercises.car;

public class Truck extends Car {
    private int capacity;

    public Truck(String brand, String color, int motor) {
        super(brand, color, motor);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //slower than car
    @Override
    public void drive() {
        speed += 5;
    }

    @Override
    public void brake() {
        speed -=5;
    }
}
