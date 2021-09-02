package com.example.truckAssessment.truck;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TruckController {
    private final TruckServiceImpl truckService;

    public TruckController(TruckServiceImpl truckService) {
        this.truckService = truckService;
    }


    @PostMapping("/register")
    public Truck registerNewStudent(@RequestBody Truck truck) {

        System.out.println("newly added truck " +truck);
        return truckService.createNewTruck(truck);
    }

    @PutMapping(path = "/update/{regNumber}")
    public Truck updateTruckDetails(@PathVariable("regNumber") Long truckId,
                                    @RequestParam(required = false) String regNumber,
                                    @RequestParam(required = false) String truckMake
    ) {
        return truckService.updateTruckDetails(truckId, regNumber, truckMake);
        

    }


    @GetMapping(path = "/search/{regNum}")
    public Truck searchTruck(@PathVariable("regNum") String regNum){

        return truckService.searchTruck(regNum);

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public String handleException(IllegalStateException exception){
        String number = exception.getMessage();
        return String.format("%s ", number);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException2(IllegalArgumentException exception){
        String number2 = exception.getMessage();
        return String.format("%s ", number2);
    }


    @DeleteMapping(path =  "/delete/{id}")
    public List<Truck> deleteStudent(@PathVariable Long id) {
        return truckService.deleteTruck(id);
    }

}
