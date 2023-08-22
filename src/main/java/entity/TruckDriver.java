package entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "driver")
@EqualsAndHashCode
@Getter
@Setter
public class TruckDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public LocalDate psychoDate;

    @NotNull
    public LocalDate medDate;

    @NotNull
    public LocalDate driverLicenseDate;

    public TruckDriver(Long id, @NotNull String firstName, @NotNull String lastName, @NotNull LocalDate psychoDate, @NotNull LocalDate medDate, @NotNull LocalDate driverLicenseDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.psychoDate = psychoDate;
        this.medDate = medDate;
        this.driverLicenseDate = driverLicenseDate;
    }

    public TruckDriver() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
