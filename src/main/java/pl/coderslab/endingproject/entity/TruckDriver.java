package pl.coderslab.endingproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.hibernate.validator.constraints.pl.PESEL;

import java.time.LocalDate;

@Entity
@Table(name = "driver")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TruckDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long driverId;

    @NotNull
    @Column(name = "firstName")
    public String firstName;

    @NotNull
    @Column(name = "lastName")
    public String lastName;

    @NotNull
    @Column(name = "psychoTestDate")
    public LocalDate psychoTestDate;

    @NotNull
    @Column(name = "medTestDate")
    public LocalDate medTestDate;

    @NotNull
    @Column(name = "driverLicenseDate")
    public LocalDate driverLicenseDate;

    @PESEL
    @Column(name = "pesel")
    public Long pesel;

}