package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class RentCar {

    static final int MENU_BUTTONS = 3;
    static Scanner sc = new Scanner(System.in);

    public static String userInput() {
        System.out.print("Your number: ");
        return sc.nextLine();
    }

    // проверка на число и промежуток
    public static Integer userInputPro(int s, int f) {
        while (true) {
            Integer answerInt;
            try {
                answerInt = Integer.parseInt(userInput());
                if (s <= answerInt && answerInt <= f) {return answerInt;}
                else System.out.println(s + " <= 'Your number' <= " + f);
            } catch (NumberFormatException e) {
                System.out.println("Number!");
            }
        }
    }

    public static void indent() {
        System.out.print("\n".repeat(5));
    }

    public static void main(String[] args) throws Exception {
        Cars cars = new Cars();
        ArrayList<Car> carArray = cars.allCars();

        MyUserInterface myUserInterface = new MyUserInterface();

        Integer answerInt;

        while (true) {
            //выводим основное меню
            myUserInterface.mainMenu(carArray);

            // ответ от пользователя
            answerInt = userInputPro(1, carArray.size() + MENU_BUTTONS);

            // выход
            if (answerInt == 1) {
                break;
            }

            // сортировка
            else if (answerInt == 2) {

                indent();
                myUserInterface.sortMenu();
                answerInt = userInputPro(1, 5);

                if (answerInt == 2) {
                    carArray = myUserInterface.sortByBrand(carArray);
                }
                else if (answerInt == 3) {
                    carArray = myUserInterface.sortByName(carArray);
                }
                else if (answerInt == 4) {
                    carArray = myUserInterface.sortByYear(carArray);
                }
                else if (answerInt == 5) {
                    carArray = myUserInterface.sortByType(carArray);
                }
            }

            // обновить таблицу
            else if (answerInt == 3) {}

            // выбор авто
            else {
                indent();
                Car pickCar = carArray.get(answerInt - MENU_BUTTONS - 1);

                // если машина свободна, то арендуем
                if (pickCar.isAvailable()) {
                    myUserInterface.rentMenu();
                    answerInt = userInputPro(1,3);
                    // безлимитная аренда
                    if (answerInt == 2) {
                        pickCar.rentOnEndless();
                    }
                    // аренда на время
                    else if (answerInt == 3) {
                        System.out.println("Please enter time <= 1000");
                        answerInt = userInputPro(1,1000);
                        pickCar.rentOnTime(answerInt);
                    }
                }

                // иначе можем отменить аренду
                else {
                    System.out.println("1.  Back");
                    System.out.println("2.  Cancel rent");
                    answerInt = userInputPro(1, 2);

                    if (answerInt == 2) {
                        pickCar.stopRentOnEndless();
                        Thread.sleep(1000);
                    }
                }
            }
            indent();
        }
    }
}
