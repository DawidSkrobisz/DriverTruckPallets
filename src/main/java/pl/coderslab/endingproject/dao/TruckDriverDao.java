package pl.coderslab.endingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.coderslab.endingproject.controller.TruckDriverController;
import pl.coderslab.endingproject.entity.Company;
import pl.coderslab.endingproject.entity.TruckDriver;

import java.time.Instant;
import java.util.List;

@Repository
@Transactional
public class TruckDriverDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveTruckDriver(TruckDriver truckDriver) {
        entityManager.merge(truckDriver);
    }


    public TruckDriver getTruckDriver(long id) {
        return entityManager.find(TruckDriver.class, id);
    }

    public void updateTruckDriver(TruckDriver truckDriver) {
        entityManager.merge(truckDriver);
    }

    public void delete(TruckDriver truckDriver) {
        entityManager.remove(entityManager.contains(truckDriver) ? truckDriver : entityManager.merge(truckDriver));
    }

    public List<TruckDriver> getAllDrivers() {
        TypedQuery<TruckDriver> query = entityManager.createQuery("SELECT t FROM TruckDriver t", TruckDriver.class);
        return query.getResultList();
    }
}