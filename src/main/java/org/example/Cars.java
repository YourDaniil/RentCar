package org.example;

import java.util.ArrayList;

public class Cars {
    private Car car1 = new Car("Lada", "Granta", 2010, "Economy");
    private Car car2 = new Car("Kia", "Rio", 2008, "Economy");
    private Car car3 = new Car("Hyundai", "Solaris", 2015, "Economy");
    private Car car4 = new Car("Volkswagen", "Polo", 2018, "Economy");
    private Car car5 = new Car("Renault", "Logan", 2016, "Economy");
    private Car car6 = new Car("Toyota", "Camry", 2019, "Business");
    private Car car7 = new Car("BMW", "3 Series", 2020, "Business");
    private Car car8 = new Car("Mercedes-Benz", "C-Class", 2021, "Business");
    private Car car9 = new Car("Audi", "A4", 2019, "Business");
    private Car car10 = new Car("Lexus", "ES", 2020, "Business");
    private Car car11 = new Car("Porsche", "911", 2022, "Premium");
    private Car car12 = new Car("Tesla", "Model S", 2021, "Premium");
    private Car car13 = new Car("Jaguar", "F-Type", 2020, "Premium");
    private Car car14 = new Car("Maserati", "Ghibli", 2021, "Premium");
    private Car car15 = new Car("Land Rover", "Range Rover", 2022, "SUV");
    private Car car16 = new Car("Toyota", "RAV4", 2021, "SUV");
    private Car car17 = new Car("Kia", "Sportage", 2020, "SUV");
    private Car car18 = new Car("Volkswagen", "Tiguan", 2019, "SUV");
    private Car car19 = new Car("Chevrolet", "Tahoe", 2020, "Minivan");
    private Car car20 = new Car("Mercedes-Benz", "V-Class", 2021, "Minivan");
    private Car car21 = new Car("Ford", "Mustang", 2022, "Sports");
    private Car car22 = new Car("Nissan", "GT-R", 2021, "Sports");
    private Car car23 = new Car("Audi", "A4", 2018, "Business");
    private Car car24 = new Car("Lexus", "ES", 2019, "Business");
    private Car car25 = new Car("Porsche", "911", 2021, "Premium");

    public ArrayList<Car> allCars() {
        ArrayList<Car> carArray = new ArrayList<>();
        carArray.add(car1); carArray.add(car2); carArray.add(car3); carArray.add(car4);
        carArray.add(car5); carArray.add(car6); carArray.add(car7); carArray.add(car8);
        carArray.add(car9); carArray.add(car10); carArray.add(car11); carArray.add(car12);
        carArray.add(car13); carArray.add(car14); carArray.add(car15); carArray.add(car16);
        carArray.add(car17); carArray.add(car18); carArray.add(car19); carArray.add(car20);
        carArray.add(car21); carArray.add(car22);carArray.add(car23);carArray.add(car24);
        carArray.add(car25);
        return carArray;
    }
}
