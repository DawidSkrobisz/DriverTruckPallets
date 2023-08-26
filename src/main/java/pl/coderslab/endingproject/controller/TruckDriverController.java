package pl.coderslab.endingproject.controller;

import pl.coderslab.endingproject.dao.TruckDriverDao;
import pl.coderslab.endingproject.entity.TruckDriver;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/truckdriver")
public class TruckDriverController {

    TruckDriverDao truckDriverDao;

    public TruckDriverController(TruckDriverDao truckDriverDao) {
        this.truckDriverDao = truckDriverDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addTruckDriver(@ModelAttribute TruckDriver truckDriver) {
        truckDriver.setFirstName("Anrew");
        truckDriver.setLastName("Kowaleski");
        truckDriver.setDriverLicenseDate(Instant.now());
        truckDriver.setPsychoTestDate(Instant.now());
        truckDriver.setMedTestDate(Instant.now());
        truckDriverDao.saveTruckDriver(truckDriver);
        return "Dodano kierowcę do bazy!";
    }

    @GetMapping("/get")
    @ResponseBody
    public TruckDriver getTruckDriver() {
        return truckDriverDao.getTruckDriver(3L);
    }

    @ResponseBody
    @GetMapping("/update")
    public TruckDriver updateTruckDriver() {
        TruckDriver truckDriver = truckDriverDao.getTruckDriver(1L);
        truckDriver.setFirstName("Michail");
        truckDriverDao.updateTruckDriver(truckDriver);
        return truckDriver;
    }

    @ResponseBody
    @GetMapping("/delete")
    public String delete() {
        TruckDriver truckDriver = truckDriverDao.getTruckDriver(1L);
        truckDriverDao.delete(truckDriver);
        return "Skasowano kierowcę";
    }
}
