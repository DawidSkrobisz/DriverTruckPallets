package pl.coderslab.endingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.coderslab.endingproject.controller.TruckDriverController;
import pl.coderslab.endingproject.entity.TruckDriver;

import java.time.Instant;

@Repository
public class TruckDriverDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveTruckDriver(TruckDriver truckDriver) {
    }


    public TruckDriver getTruckDriver(long id) {
        return entityManager.find(TruckDriver.class, id);
        // return new TruckDriver(1L, "Janusz", "Januszowaty", Instant.now(), Instant.now(), Instant.now());
    }
}