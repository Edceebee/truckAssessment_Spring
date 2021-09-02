package com.example.truckAssessment.truck;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TruckServiceImplTest {

    @Autowired
    TruckRepository truckRepository;

    @Autowired
    TruckServiceImpl truckService;



    @Test
    @Order(1)
    void testThatUserCanCreateTruck(){

        Truck truck = new Truck();

          truck.setTruckId(9L);
        truck.setTruckMake("Bentley");
        truck.setTruckModel("Bentley model");
        truck.setRegNumber("0098");
        truck.setYearOfPurchase("2010");

        truckRepository.save(truck);

        assertThat(truck).isNotNull();

    }

    @Test
    @Order(3)
    void testThatWeCanReadAllTrucks(){
        List<Truck> allTrucks = truckRepository.findAll();
//        log.info("all trucks --> {}", allTrucks);
        assertThat(allTrucks).size().isEqualTo(4);
        System.out.println("all trucks are " + allTrucks);


    }

    @Test
    @Order(2)
    void testThatUserCanUpdateTruckDetails(){

        Truck newTruck = truckRepository.findByRegNumber("0002").get();
        log.info("Details of truck -> {}", newTruck);

        newTruck.setTruckMake("Bent");
        newTruck.setTruckModel("Bent Model");
        truckRepository.save(newTruck);

        assertThat(newTruck.getTruckMake().equals("Bent"));
        assertThat(newTruck.getTruckModel().equals("Bent Model"));

        log.info("New details of truck -> {}", newTruck);


    }

    @Test
    void testThatTruckCanBeDeleted(){
        truckRepository.deleteById(2L);

        assertThat(truckRepository.existsById(2L)).isFalse();
//        log.info("Details of truck repo -> {}", truckRepository);


    }


}