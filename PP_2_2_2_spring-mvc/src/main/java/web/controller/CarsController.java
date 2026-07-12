package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarsDao;
import web.dao.CarsDaoImpl;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping (value = "/cars")
public class CarsController {
    private final CarsDaoImpl carsDao;
    @Autowired
    public CarsController(CarsDaoImpl carsDao) {
        this.carsDao = carsDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cars", carsDao.index());
        return "cars";
    }
    @GetMapping(value = "/cars")
    public String count(
        @RequestParam(required = false) Integer count, Model model) {
        List<Car> cars;
        if (count == null || count >= 5 || count <=0) {
            cars = carsDao.index();
        } else {
            cars = carsDao.count(count);
        }
        model.addAttribute("cars", cars);
        model.addAttribute("count", count);
        return "cars";

    }

}