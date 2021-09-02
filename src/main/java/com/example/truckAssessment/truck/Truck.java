package com.example.truckAssessment.truck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table (name = "truck" )
@SQLDelete(sql = "UPDATE truck SET deleted = true WHERE id=?")
@FilterDef(name = "deletedTruckFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedTruckFilter", condition = "deleted = :isDeleted")
@NoArgsConstructor
@AllArgsConstructor
@Data

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
    private boolean isDeleted = Boolean.FALSE;

    public Truck(String regNumber, String truckMake, String truckModel, String yearOfPurchase) {
        this.regNumber = regNumber;
        this.truckMake = truckMake;
        this.truckModel = truckModel;
        this.yearOfPurchase = yearOfPurchase;
    }



}
