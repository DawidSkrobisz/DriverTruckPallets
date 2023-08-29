package pl.coderslab.endingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.coderslab.endingproject.entity.Company;
import pl.coderslab.endingproject.entity.Truck;

import java.util.List;

@Repository
@Transactional
public class CompanyDao {
    @PersistenceContext
    private EntityManager entityManager;


    public void saveCompany(Company company) {
        entityManager.merge(company);
    }

    public Company findByIdCompany(long id) {
        return entityManager.find(Company.class, id);
    }

    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company) ? company: entityManager.merge(company));
    }

    public List<Company> getAllCompanys() {
        TypedQuery<Company> query = entityManager.createQuery("SELECT t FROM Company t", Company.class);
        return query.getResultList();
    }
}