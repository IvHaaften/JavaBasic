package oo_exercises.car;

public class Car implements Vehicle{
    private String brand;
    private String color;
    private Propulsion motor;
    protected int speed;

    @Override
    public String toString() {
        return "The "+ color + " " + brand + " car has a speed of " + speed ;
    } //sets the print method

    public void drive() {
        //modulated by motor power
        speed += 2  * motor.speedIncrease;
    }
    public void brake() {
        //not modulated by motor, but by brakes
        speed -= 10;
    }

    public Car(String brand, String color, int motor) {
        this.brand = brand;
        this.color = color;
        this.motor = new Propulsion(motor);
    }
}
