package org.example;

import java.util.*;

public class MyUserInterface {
    public void mainMenu(ArrayList<Car> arrayList) {
        System.out.println("1.  Exit");
        System.out.println("2.  Sort by...");
        System.out.println("3.  Refresh");
        int i = 3;
        for (Car car : arrayList) {
            i++;
            if (0 <= i && i <= 9) System.out.println(i + ".  " + car);
            else System.out.println(i + ". " + car);

        }
    }

    public void sortMenu() {
        System.out.println("1.  Back");
        System.out.println("2.  Sort by 'Brand'");
        System.out.println("3.  Sort by 'Name'");
        System.out.println("4.  Sort by 'Year'");
        System.out.println("5.  Sort by 'Type'");
    }

    public void rentMenu() {
        System.out.println("1.  Back");
        System.out.println("2.  Rent a car for an unlimited time");
        System.out.println("3.  Rent a car for a period of time");
    }

    public ArrayList<Car> sortByBrand(ArrayList<Car> arrayList) {
        ArrayList<Car> newArrayList = new ArrayList<>(arrayList);
        Collections.sort(newArrayList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c1.getCarBrand().compareTo(c2.getCarBrand());
            }
        });
        return newArrayList;
    }
    public ArrayList<Car> sortByName(ArrayList<Car> arrayList) {
        ArrayList<Car> newArrayList = new ArrayList<>(arrayList);
        newArrayList.sort(new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c1.getCarName().compareTo(c2.getCarName());
            }
        });
        return newArrayList;
    }
    public ArrayList<Car> sortByYear(ArrayList<Car> arrayList) {
        ArrayList<Car> newArrayList = new ArrayList<>(arrayList);
        Collections.sort(newArrayList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return Integer.compare(c2.getCarYear(), c1.getCarYear()); // Используем Integer.compare()
            }
        });
        return newArrayList;
    }
    public ArrayList<Car> sortByType(ArrayList<Car> arrayList) {
        ArrayList<Car> newArrayList = new ArrayList<>(arrayList);
        Collections.sort(newArrayList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c1.getCarType().compareTo(c2.getCarType());
            }
        });
        return newArrayList;
    }
}