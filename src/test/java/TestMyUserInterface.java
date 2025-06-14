import org.example.Car;
import org.example.MyUserInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyUserInterface {
    @Test
    public void testSortByBrand() {
        MyUserInterface myUserInterface = new MyUserInterface();
        Car car1 = new Car("Lada", "Granta", 2010, "Economy");
        Car car2 = new Car("Kia", "Rio", 2008, "Economy");
        Car car3 = new Car("Hyundai", "Solaris", 2015, "Economy");

        ArrayList<Car> arrayList = new ArrayList<>();
        arrayList.add(car1); arrayList.add(car2); arrayList.add(car3);
        ArrayList<Car> arrayListSorted = new ArrayList<>();
        arrayListSorted.add(car3); arrayListSorted.add(car2); arrayListSorted.add(car1);

        assertEquals(arrayListSorted, myUserInterface.sortByBrand(arrayList));
    }

    @Test
    public void testSortByName() {
        MyUserInterface myUserInterface = new MyUserInterface();
        Car car1 = new Car("Lada", "CGranta", 2010, "Economy");
        Car car2 = new Car("Kia", "BRio", 2008, "Economy");
        Car car3 = new Car("Hyundai", "ASolaris", 2015, "Economy");

        ArrayList<Car> arrayList = new ArrayList<>();
        arrayList.add(car1); arrayList.add(car2); arrayList.add(car3);
        ArrayList<Car> arrayListSorted = new ArrayList<>();
        arrayListSorted.add(car3); arrayListSorted.add(car2); arrayListSorted.add(car1);

        assertEquals(arrayListSorted, myUserInterface.sortByName(arrayList));
    }

    @Test
    public void testSortByYear() {
        MyUserInterface myUserInterface = new MyUserInterface();
        Car car1 = new Car("Lada", "Granta", 2010, "Economy");
        Car car2 = new Car("Kia", "Rio", 2008, "Economy");
        Car car3 = new Car("Hyundai", "Solaris", 2015, "Economy");

        ArrayList<Car> arrayList = new ArrayList<>();
        arrayList.add(car1); arrayList.add(car2); arrayList.add(car3);
        ArrayList<Car> arrayListSorted = new ArrayList<>();
        arrayListSorted.add(car3); arrayListSorted.add(car1); arrayListSorted.add(car2);

        assertEquals(arrayListSorted, myUserInterface.sortByYear(arrayList));
    }

    @Test
    public void testSortByType() {
        MyUserInterface myUserInterface = new MyUserInterface();
        Car car1 = new Car("Lada", "Granta", 2010, "C");
        Car car2 = new Car("Kia", "Rio", 2008, "B");
        Car car3 = new Car("Hyundai", "Solaris", 2015, "A");

        ArrayList<Car> arrayList = new ArrayList<>();
        arrayList.add(car1); arrayList.add(car2); arrayList.add(car3);
        ArrayList<Car> arrayListSorted = new ArrayList<>();
        arrayListSorted.add(car3); arrayListSorted.add(car2); arrayListSorted.add(car1);

        assertEquals(arrayListSorted, myUserInterface.sortByType(arrayList));
    }
}
