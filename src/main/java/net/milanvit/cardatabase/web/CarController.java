package net.milanvit.cardatabase.web;

import net.milanvit.cardatabase.domain.Car;
import net.milanvit.cardatabase.domain.CarRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
}
