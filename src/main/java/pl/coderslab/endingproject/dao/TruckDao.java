package pl.coderslab.endingproject.dao;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.coderslab.endingproject.entity.Truck;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
@Transactional
public class TruckDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveTruck(Truck truck) {
        entityManager.merge(truck);
    }

    public Truck findByIdTruck(long id) {
        return entityManager.find(Truck.class, id);
    }

    public void updateTruck(Truck truck) {
        entityManager.merge(truck);
    }

    public void deleteTruck(Truck truck) {
        entityManager.remove(entityManager.contains(truck) ? truck : entityManager.merge(truck));
    }

    public List<Truck> getAllTrucks() {
        TypedQuery<Truck> query = entityManager.createQuery("SELECT t FROM Truck t", Truck.class);
        return query.getResultList();
    }


}