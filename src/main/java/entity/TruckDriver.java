package entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
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
    public Long id;

    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public Instant psychoDate;

    @NotNull
    public Instant medDate;

    @NotNull
    public Instant driverLicenseDate;



}
