package com.example.truckAssessment.truck;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class TruckConfig {
    @Bean
    CommandLineRunner commandLineRunner(TruckRepository repository) {
        return args -> {
            Truck truck1 = new Truck(
                    "0001",
                    "Ford",
                    "ford",
                    "2005"
            );
            Truck truck2 = new Truck(
                    "0002",
                    "Nissan",
                    "nissan",
                    "2006"
            );
            Truck truck3 = new Truck(
                    "0003",
                    "Ford",
                    "ford",
                    "2005"
            );

                repository.saveAll(
                        List.of(truck1, truck2, truck3)
                );

//            log.info("Objects-->{}", repository.findAll());
        };

    }
}
