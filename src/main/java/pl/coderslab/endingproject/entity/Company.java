package pl.coderslab.endingproject.entity;

import entity.Loading;
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
    public Long companyId;

    @NotNull
    @Column(name="companyName")
    public String companyName;

    @NotNull
    @Column(name="companyAdress")
    public String companyAdress;

    @NotNull
    @Column(name="companyVat")
    public String companyVat;

   /* @OneToMany(mappedBy = "company")
    private List<Loading> loadings = new ArrayList<>();*/

}