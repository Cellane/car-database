package net.milanvit.cardatabase;

import net.milanvit.cardatabase.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
    private final CarRepository repository;
    private final OwnerRepository ownerRepository;
    private final UserRepository userRepository;

    public CardatabaseApplication(CarRepository repository, OwnerRepository ownerRepository, UserRepository userRepository) {
        this.repository = repository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
    }

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

            userRepository.save(new User("Cellane", "$2a$10$i6SllusxMmb.cKAVbtaia.OYVQY90mMZiyiOvgp/TG/CVHAgWiDPa", "ADMIN"));
            userRepository.save(new User("Voilane", "$2a$10$i6SllusxMmb.cKAVbtaia.OYVQY90mMZiyiOvgp/TG/CVHAgWiDPa", "USER"));
        };
    }
}
