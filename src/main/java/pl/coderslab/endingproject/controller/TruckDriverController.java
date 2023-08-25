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
        truckDriver.setDriverId(generateUniqueDriverId());
        truckDriver.setFirstName("John");
        truckDriver.setLastName("Kielbowski");
        truckDriver.setDriverLicenseDate(Instant.now());
        truckDriver.setPsychoTestDate(Instant.now());
        truckDriver.setMedTestDate(Instant.now());
        truckDriverDao.saveTruckDriver(truckDriver);
        return "Dodano kierowcę do bazy!";
    }

    private Long generateUniqueDriverId() {
        // Tutaj generuj unikalne ID, na przykład na podstawie czasu lub innej logiki
        return System.currentTimeMillis();
    }

    @GetMapping("/get")
    @ResponseBody
    public TruckDriver getTruckDriver() {
       return truckDriverDao.getTruckDriver(1L);
    }

    @ResponseBody
    @GetMapping("/update")
    public TruckDriver updateTruckDriver() {
        TruckDriver truckDriver = truckDriverDao.getTruckDriver(1L);
        truckDriver.setFirstName("Roman");
        truckDriverDao.updateTruckDriver(truckDriver);
        return truckDriver;
    }
}
