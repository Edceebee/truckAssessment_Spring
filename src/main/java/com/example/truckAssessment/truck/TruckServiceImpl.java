package com.example.truckAssessment.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TruckServiceImpl {

    @Autowired
    TruckRepository truckRepository;


    public List<Truck> getStudent() {

        return truckRepository.findAll();
    }

    public Truck createNewTruck(Truck truck) {
        Optional<Truck> truckByRegNumber = truckRepository.findByRegNumber(truck.getRegNumber());
        if (truckByRegNumber.isPresent()) {
            throw new IllegalArgumentException("Registration number already taken");
        }
        truckRepository.save(truck);
        return truck;
    }


    public Truck updateTruckDetails(Long truckId, String regNumber, String truckMake) {


        Truck truck = truckRepository.findById(truckId).orElseThrow(() -> new IllegalStateException
                ("Truck with id " + truckId + " does not exist"));

        if (truckMake != null && truckMake.length() > 0 && !Objects.equals(truck.getTruckMake(), truckMake)) {
            truck.setTruckMake(truckMake);
        }
        if (regNumber != null && regNumber.length() > 0 && !Objects.equals(truck.getRegNumber(), regNumber)) {
            Optional<Truck> truckByRegNumber = truckRepository.findByRegNumber(regNumber);

            if (truckByRegNumber.isPresent()) {
                throw new IllegalStateException("reg number taken");
            }
            truck.setRegNumber(regNumber);
        }

        return truck;

    }

    public Truck searchTruck(String regNum) {
        Optional<Truck> foundTruck = truckRepository.findByRegNumber(regNum);

        if (foundTruck.isPresent()) {
            return foundTruck.get();
        } else {
            throw new IllegalArgumentException("Sorry, truck with registration number " + regNum + " does not exist");
        }

    }


    public List<Truck> deleteTruck(Long id) {

        List<Truck> allTrucks = new ArrayList<>();

        boolean exists = truckRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Truck with id " + id + " does not exist");

        }

        truckRepository.deleteById(id);

        return allTrucks;
    }

//    public Iterable<Truck> findAll(boolean isDeleted){
//
//        Session session = entityManager.unwrap(Session.class);
//        Filter filter = session.enableFilter("deletedProductFilter");
//        filter.setParameter("isDeleted", isDeleted);
//        Iterable<Truck> truck =  truckRepository.findAll();
//        session.disableFilter("deletedProductFilter");
//        return truck;
//    }
}
