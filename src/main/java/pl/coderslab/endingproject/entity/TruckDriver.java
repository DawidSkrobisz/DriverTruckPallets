package pl.coderslab.endingproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
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
    @Column(name="firstName")
    public String firstName;

    @NotNull
    @Column(name="lastName")
    public String lastName;

    @NotNull
    @Column(name="psychoTestDate")
    public Instant psychoTestDate;

    @NotNull
    @Column(name="medTestDate")
    public Instant medTestDate;

    @NotNull
    @Column(name="driverLicenseDate")
    public Instant driverLicenseDate;

}