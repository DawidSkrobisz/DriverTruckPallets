package entity;

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
    public Long id;

    @NotNull
    @Column(name="first_name")
    public String firstName;

    @NotNull
    @Column(name="last_name")
    public String lastName;

    @NotNull
    @Column(name="psycho_test_date")
    public Instant psychoDate;

    @NotNull
    @Column(name="medical_test_date")
    public Instant medDate;

    @NotNull
    @Column(name="license_expiry_date")
    public Instant driverLicenseDate;

}