package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarsDaoImpl implements CarsDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        Car car = new Car("Geely", "Mondjaro", 2023);
        Car car1 = new Car("Cherry", "Tiggo", 2020);
        Car car2 = new Car("Toyota", "Camry", 2015);
        Car car3 = new Car("Hyndai", "Creta", 2020);
        Car car4 = new Car("Ford", "Escape", 2011);
        Car car5 = new Car("Opel", "Blitz", 1940);
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }

    public List<Car> index() {
        return cars;
    }
    public List<Car> count(int count) {
        if (count >= 5 || count <=0) {
            return cars;
        }
        return new ArrayList<Car>(cars.subList(0, count));
    }
}
