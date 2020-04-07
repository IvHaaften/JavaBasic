package oo_exercises.car;

public class Bicycle implements Vehicle{



    private String brand;
    private String color;
    private Propulsion pedalPower;
    protected int speed;

    public Bicycle(String brand, String color, int power) {
        this.brand = brand;
        this.color = color;
        this.pedalPower = new Propulsion(power);
    }

    @Override
    public String toString() {
        return "The "+ color + " " + brand + " bicycle has a speed of " + speed ;
    }

    @Override
    public void drive() {
        //speed is modulated by power
        speed += pedalPower.speedIncrease*2;
    }

    @Override
    public void brake() {
        //braking is constant with the brakes
        speed -= 2;

    }
}
