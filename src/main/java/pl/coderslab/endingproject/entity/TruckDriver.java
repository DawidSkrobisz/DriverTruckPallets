package pl.coderslab.endingproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Instant psychoTestDate;

    @NotNull
    @Column(name = "medTestDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Instant medTestDate;

    @NotNull
    @Column(name = "driverLicenseDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Instant driverLicenseDate;

    @PESEL
    @Column(name = "pesel")
    public Long pesel;

}