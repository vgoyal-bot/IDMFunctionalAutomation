package snippets.java.collections;

import java.util.ArrayList;
import java.util.List;

class Car {
}

class Suzuki extends Car {
}

public class CarDealer{
    public void addCar(List<Car> cars) {
        cars.add(new Suzuki());
    }

    public void addCar(Car cars) {
    }

    public static void main(String[] args) {
        List<Suzuki> cars = new ArrayList<Suzuki>();
        cars.add(new Suzuki());
        cars.add(new Suzuki());
        CarDealer  carDealerIndia = new CarDealer();
        // carDealerIndia.addCar(cars); UNCOMMENT THIS LINE TO MAKE THIS WORK AS EXPECTED.
    }
}
