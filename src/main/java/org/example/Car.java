package org.example;

public class Car {
    private String carBrand;
    private String carName;
    private int carYear;
    private String carType;
    private boolean available = true;

    public Car(String carBrand, String carName, int carYear, String carType) {
        setCarBrand(carBrand);
        setCarName(carName);
        setCarYear(carYear);
        setCarType(carType);
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private boolean running;
    private int seconds ;

    public boolean isRunning() {
        return running;
    }

    public int getSeconds() {
        return seconds;
    }

    public void rentOnTime(int time) {
        running = true;
        setAvailable(false);
        seconds = 0;
        Thread rentOnTimeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < time; i++) {
                        seconds++;
                        Thread.sleep(1000);
                        if (!running) break;
                    }
                    setAvailable(true);
                } catch (InterruptedException e) {
                    running = false;
                }
                if (running){
                    System.out.println("\n" + getCarBrand() +
                            " " + getCarName() +
                            " " + getCarYear() +
                            " is available");
                    System.out.println("Pass time: " + seconds);
                }
            }
        });
        rentOnTimeThread.start();
    }

    public void rentOnEndless() throws InterruptedException {
        running = true;
        setAvailable(false);
        seconds = 0;
        Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    seconds++;
                    try {
                        Thread.sleep(1000); // обновляем каждую секунду
                    } catch (InterruptedException e) {
                        running = false;
                    }
                }
            }});
        timerThread.start();
    }
    public void stopRentOnEndless() {
        running = false;
        setAvailable(true);
        System.out.println("\n" + getCarBrand() +
                " " + getCarName() +
                " " + getCarYear() +
                " is available");
        System.out.println("Pass time: " + seconds);
    }

    final int INTERVAL = 15;
    @Override
    public String toString() {
        String res = "";
        res += carBrand + " ".repeat(INTERVAL - carBrand.length())
                + carName + " ".repeat(INTERVAL - carName.length())
                + carYear + " ".repeat(INTERVAL - 4)
                + carType + " ".repeat(INTERVAL - carType.length()) + " available: "
                + available;
        return res;
    }
}