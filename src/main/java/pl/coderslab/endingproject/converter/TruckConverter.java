package pl.coderslab.endingproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.endingproject.dao.TruckDao;
import pl.coderslab.endingproject.entity.Truck;

@Component
public class TruckConverter implements Converter<String, Truck> {

    @Autowired
    private TruckDao truckDao;

    @Override
    public Truck convert(String truckId) {
        if (truckId == null || truckId.isEmpty()) {
            return null;
        }
        Long id = Long.parseLong(truckId);
        return truckDao.findByIdTruck(id);
    }
}