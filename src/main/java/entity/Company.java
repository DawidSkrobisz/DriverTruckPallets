package entity;

import jakarta.persistence.Id;
import java.time.LocalDate;

public class Company {

    @Id
    public Long id;

    public String companyName;

    public Integer palletsPlus;

    public Integer palletsMinus;

    public Integer palletsSaldo;

    public LocalDate loadingDate;

    public String loadingNumer;


}
