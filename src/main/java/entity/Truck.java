package entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import java.time.Instant;

@Entity
@Table(name = "truck")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotNull
    @Column(name="model")
    public String truckModel;
    @NotNull
    @Column(name="license_plate")
    public String truckPlates;
    @NotNull
    @Column(name="vin_number")
    public Integer vinNumber;
    @NotNull
    @Column(name="inspection_date")
    public Instant serviceDate;
    @NotNull
    @Column(name="insurance_date")
    public Instant insuranceDate;
    @NotNull
    //dopisać adnotację Column i stworzyć tabelę w bazie danych
    public Integer acctualSaldoPallets;

}