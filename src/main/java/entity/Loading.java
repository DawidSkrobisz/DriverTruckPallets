package entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String companyName;

    @NotNull
    public Integer loadedPallets;

    @NotNull
    public Integer deliveryPallets;

    @NotNull
    public Integer retournedPallets;

    @NotNull
    public LocalDate loadingDate;

    @NotNull
    public String loadingNumer;

    @Enumerated(EnumType.STRING)
    public Status status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @Column(name = "saldoFromLoading")
    public Integer saldoPallets() {
        return deliveryPallets - retournedPallets;
    }

    public static enum Status {
        NEW, COMPLETED, ARCHIVED;
    }
}
