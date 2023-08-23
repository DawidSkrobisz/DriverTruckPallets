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
    public String truckModel;
    @NotNull
    public String truckPlates;
    @NotNull
    public Integer vinNumber;
    @NotNull
    public Instant serviceDate;
    @NotNull
    public Instant insuranceDate;


}