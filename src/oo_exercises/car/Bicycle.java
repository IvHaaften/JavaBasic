package oo_exercises.car;

public class Bicycle implements Vehicle{
    private String brand;
    private String color;
    protected int speed;

    public Bicycle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return "The "+ color + " " + brand + " bicycle has a speed of " + speed ;
    }

    @Override
    public void drive() {
        speed += 2;
    }

    @Override
    public void brake() {
        speed -= 2;

    }
}
