package oo_exercises.car;

public class RaceCar extends Car {
    int topSpeed;

    public RaceCar(String brand, String color) {
        super(brand, color);
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
}
