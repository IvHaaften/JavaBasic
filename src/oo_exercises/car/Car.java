package oo_exercises.car;

public class Car implements Vehicle{
    private String brand;
    private String color;
    protected int speed;

    @Override
    public String toString() {
        return "The "+ color + " " + brand + " car has a speed of " + speed ;
    } //sets the print method

    public void drive() {
        speed += 10;
    }
    public void brake() {
        speed -= 10;
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }
}
