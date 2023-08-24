package entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @Column(name="companyName")
    public String companyName;

    @NotNull
    @Column(name="companyAdress")
    public String companyAdress;

    @NotNull
    @Column(name="companyVat")
    public String companyVat;

    @NotNull
    public Integer acctualPlusSaldo;

    @NotNull
    public Integer acctualDebtSaldo;

    @OneToMany(mappedBy = "company")
    private List<Loading> loadings = new ArrayList<>();

}