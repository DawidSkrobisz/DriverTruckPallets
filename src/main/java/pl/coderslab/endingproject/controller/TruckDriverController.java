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
        truckDriverDao.saveTruckDriver(truckDriver);
        return "Truck driver added successfully!";
    }

    @GetMapping("/get")
    @ResponseBody
    public TruckDriver getTruckDriver() {
       return truckDriverDao.getTruckDriver(1L);
    }
}
