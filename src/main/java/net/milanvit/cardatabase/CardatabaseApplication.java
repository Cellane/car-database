package net.milanvit.cardatabase;

import net.milanvit.cardatabase.domain.Car;
import net.milanvit.cardatabase.domain.CarRepository;
import net.milanvit.cardatabase.domain.Owner;
import net.milanvit.cardatabase.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Owner owner1 = ownerRepository.save(new Owner("John", "Johnson"));
            Owner owner2 = ownerRepository.save(new Owner("Mary", "Robinson"));

            Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
            repository.save(car);

            car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
            repository.save(car);

            car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
            repository.save(car);
        };
    }
}
