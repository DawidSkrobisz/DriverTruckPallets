package entity;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class Truck {

    @Id
    public Long id;

    public String truckModel;

    public String truckPlates;

    public Integer distanceTruck;

    public Integer vinNumber;

    public LocalDate serviceDate;

    public LocalDate insuranceDate;

}
