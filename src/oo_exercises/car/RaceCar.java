package oo_exercises.car;

public class RaceCar extends Car {
    int topSpeed;

    public RaceCar(String brand, String color, int motor) {
        super(brand, color, motor);
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
}
