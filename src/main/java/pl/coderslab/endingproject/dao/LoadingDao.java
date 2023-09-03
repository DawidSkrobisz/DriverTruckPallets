package pl.coderslab.endingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.coderslab.endingproject.entity.Company;
import pl.coderslab.endingproject.entity.Loading;

import java.util.List;

@Repository
@Transactional
public class LoadingDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveLoading(Loading loading) {
        entityManager.merge(loading);
    }

    public Loading findByIdLoading(long id) {
        return entityManager.find(Loading.class, id);
    }

/*    public void updateCompany(Company company) {
        entityManager.merge(company);
    }*/

    public void deleteLoading(Loading loading) {
        entityManager.remove(entityManager.contains(loading) ? loading: entityManager.merge(loading));
    }

    public List<Company> getAllCompanies() {
        TypedQuery<Company> query = entityManager.createQuery("SELECT c FROM Company c", Company.class);
        return query.getResultList();
    }

    public List<Loading> getAllLoadings() {
        TypedQuery<Loading> query = entityManager.createQuery("SELECT l FROM Loading l", Loading.class);
        return query.getResultList();
    }
    

}