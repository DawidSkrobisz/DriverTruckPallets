package entity;

import jakarta.persistence.Id;

import java.time.Instant;
import java.time.LocalDate;

public class Truck {

    @Id
    public Long id;

    public String truckModel;

    public String truckPlates;

    public Integer vinNumber;

    public Instant serviceDate;

    public Instant insuranceDate;


}
