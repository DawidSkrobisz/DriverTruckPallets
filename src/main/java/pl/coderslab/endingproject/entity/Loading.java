package pl.coderslab.endingproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "palette")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long paletteId;

    @NotNull
    public Integer loadedPallets;

    @NotNull
    public Integer exchangedPallets;

    @NotNull
    public Integer returnedPallets;

    @NotNull
    public LocalDate loadingDate;

    @NotNull
    public String loadingNumber;

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
        return returnedPallets - exchangedPallets;
    }

    @NotNull
    public static enum Status {
        NEW, COMPLETED, ARCHIVED;
    }
}
