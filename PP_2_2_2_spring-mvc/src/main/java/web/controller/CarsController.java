package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model) {
        Car car = new Car("Geely", "Mondjaro", 2023);
        Car car1 = new Car("Cherry", "Tiggo", 2020);
        Car car2 = new Car("Toyota", "Camry", 2015);
        Car car3 = new Car("Hyndai", "Creta", 2020);
        Car car4 = new Car("Ford", "Escape", 2011);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        List<String> messages = new ArrayList<>();
        messages.add("CARS!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("cars", messages);
        return "index";
    }

}