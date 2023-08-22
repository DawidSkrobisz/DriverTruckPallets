package entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Loading {

    @Id
    public Long id;

    public String companyName;

    public Integer deliveryPallets;

    public Integer retournedPallets;

    public LocalDate loadingDate;

    public String loadingNumer;

    @Enumerated(EnumType.STRING)
    public Status status;

    public Integer saldoPallets() {
        return deliveryPallets - retournedPallets;
    }

    public static enum Status {
        NEW, COMPLETED, ARCHIVED; //doczytać
    }
}
