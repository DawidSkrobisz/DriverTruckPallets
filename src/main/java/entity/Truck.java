package entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name="truckModel")
    public String truckModel;

    @NotNull
    @Column(name="truckPlates")
    public String truckPlates;

    @NotNull
    @Column(name="vinNumber")
    public Integer vinNumber;

    @NotNull
    @Column(name="serviceDate")
    public Instant serviceDate;

    @NotNull
    @Column(name="insuranceDate")
    public Instant insuranceDate;

    @NotNull
    //dopisać adnotację Column i stworzyć tabelę w bazie danych
    public Integer acctualSaldoPallets;

    @OneToMany(mappedBy = "truck")
    private List<Loading> loadings = new ArrayList<>();

}