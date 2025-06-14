import org.example.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCar {
    final int INTERVAL = 15;
    // проверка конструктора и геттеров
    @Test
    public void testCarConstructorAndGetters () {
        Car car = new Car("Lada", "Granta", 2010, "Economy");

        assertEquals("Lada", car.getCarBrand());
        assertEquals("Granta", car.getCarName());
        assertEquals(2010, car.getCarYear());
        assertEquals("Economy", car.getCarType());
        assertTrue(car.isAvailable());
    }

    // проверка сеттеров
    @Test
    public void testSetters() {
        Car car = new Car("Lada", "Granta", 2010, "Economy");

        car.setCarBrand("Tesla"); car.setCarName("Y"); car.setCarYear(2025);
        car.setCarType("Rich");car.setAvailable(false);

        assertEquals("Tesla", car.getCarBrand());
        assertEquals("Y", car.getCarName());
        assertEquals(2025, car.getCarYear());
        assertEquals("Rich", car.getCarType());
        assertFalse(car.isAvailable());
    }

    // проверка ренты авто на время БЕЗ внешнего прерывания
    @Test
    public void testRentOnTimeTRUE() throws InterruptedException {
        Car car = new Car("Lada", "Granta", 2010, "Economy");
        int time = 5;
        car.rentOnTime(time);
        assertFalse(car.isAvailable());
        // проверяем каждые полсекунды работу потока
        for (int i = 0; i < time*2; i++) {
            assertTrue(car.isRunning());
            Thread.sleep(500);
        }
        assertEquals(time, car.getSeconds());
        assertTrue(car.isAvailable());
    }

    // проверка на изменение переменных, останавливающих поток
    @Test
    public void testStopRentOnEndless() {
        Car car = new Car("Lada", "Granta", 2010, "Economy");
        car.setAvailable(false);
        car.stopRentOnEndless();
        assertTrue(car.isAvailable());
        assertFalse(car.isRunning());
    }

    // проверка ренты авто на время С внешним прерыванием
    @Test
    public void testRentOnTimeFalse() throws InterruptedException {
        Car car = new Car("Lada", "Granta", 2010, "Economy");
        int time = 6;
        int whenStop = 3;
        car.rentOnTime(time);
        // проверяем каждые полсекунды работу потока (на половине временного отрезка)
        for (int i = 0; i < whenStop*2; i++) {
            assertTrue(car.isRunning());
            Thread.sleep(450); // небольшая погрешность
        }
        // вручную останавливаем аренду авто
        car.stopRentOnEndless();

        assertEquals(whenStop, car.getSeconds());
        assertTrue(car.isAvailable());
        assertFalse(car.isRunning());
    }

    // проверка ренты авто, таймер
    @Test
    public void testRrentOnEndless() throws InterruptedException {
        Car car = new Car("Lada", "Granta", 2010, "Economy");
        int whenStop = 3;
        car.rentOnEndless();
        // проверяем каждые полсекунды работу потока (на половине временного отрезка)
        for (int i = 0; i < whenStop*2; i++) {
            assertTrue(car.isRunning());
            Thread.sleep(450); // погрешность
        }
        // вручную останавливаем аренду авто
        car.stopRentOnEndless();

        assertEquals(whenStop, car.getSeconds());
        assertTrue(car.isAvailable());
        assertFalse(car.isRunning());
    }

    // проверка как выводится параметры в консоли
    @Test
    public void testToString() {
        Car car = new Car("Lada", "Granta", 2010, "Economy");
        String str = "Lada           Granta         2010           Economy         available: true";
        assertEquals(str, car.toString());
    }
}
