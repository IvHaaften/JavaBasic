package oo_exercises.car;

public class Main {
    public static void main(String[] args) {
        //test all classes

        Car car = new Car("Tesla", "red", 5);

        car.drive();
        car.brake();
        System.out.println(car);

        Car hisCar = new Car("Suzuki", "gray", 4);
        for(int i = 0; i<3; i++) hisCar.drive();
        System.out.println(hisCar);

        Truck truck1 = new Truck ("Volvo", "blue", 1);
        truck1.setCapacity(1000);
        truck1.drive();
        System.out.println(truck1);

        RaceCar mySecondCar = new RaceCar("Ferrari", "red", 10);
        System.out.println(mySecondCar);

        Bicycle myBike = new Bicycle("Vanmoof", "gray", 2);
        System.out.println(myBike);


    }
}
