package dao;

import entity.Truck;
import jakarta.persistence.EntityManager;

public class TruckDao {

    private EntityManager entityManager;

    public void saveTruck(Truck truck) {
        entityManager.persist(truck);
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
}
