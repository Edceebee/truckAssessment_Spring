package com.example.truckAssessment.truckImplTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Truck {
    @Id
    @SequenceGenerator(
            name = "truck_sequence",
            sequenceName = "truck_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "truck_sequence"
    )
    private Long truckId;
    private String regNumber;
    private String truckMake;
    private String truckModel;
    private String yearOfPurchase;

    public Truck(String regNumber, String truckMake, String truckModel, String yearOfPurchase) {
        this.regNumber = regNumber;
        this.truckMake = truckMake;
        this.truckModel = truckModel;
        this.yearOfPurchase = yearOfPurchase;
    }



}
