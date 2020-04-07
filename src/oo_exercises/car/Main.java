package oo_exercises.car;

public class Main {
    public static void main(String[] args) {
        //test all classes

        Car car = new Car("Tesla", "red");

        car.drive();
        car.brake();
        System.out.println(car);

        Car hisCar = new Car("Suzuki", "gray");
        for(int i = 0; i<3; i++) hisCar.drive();
        System.out.println(hisCar);

        Truck truck1 = new Truck ("Volvo", "blue");
        truck1.setCapacity(1000);
        truck1.drive();
        System.out.println(truck1);

        RaceCar mySecondCar = new RaceCar("Ferrari", "red");
        System.out.println(mySecondCar);

        Bicycle myBike = new Bicycle("Vanmoof", "gray");
        System.out.println(myBike);


    }
}
