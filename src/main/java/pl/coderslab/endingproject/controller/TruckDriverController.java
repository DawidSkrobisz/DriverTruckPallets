package pl.coderslab.endingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pl.coderslab.endingproject.dao.TruckDriverDao;
import pl.coderslab.endingproject.entity.Company;
import pl.coderslab.endingproject.entity.TruckDriver;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/truckdriver")
public class TruckDriverController {

    TruckDriverDao truckDriverDao;

    public TruckDriverController(TruckDriverDao truckDriverDao) {
        this.truckDriverDao = truckDriverDao;
    }

    @GetMapping("/add")
    public String showAddTruckDriverForm(Model model) {
        TruckDriver truckDriver = new TruckDriver();
        model.addAttribute("truckDriver", truckDriver);
        return "truckdriver/add";
    }


    @PostMapping("/add")
    @ResponseBody
    public String addTruckDriver(@RequestParam Long driverId,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam Instant psychoTestDate,
                                 @RequestParam Instant medTestDate,
                                 @RequestParam Instant driverLicenseDate) {
        TruckDriver truckDriver = new TruckDriver();
        truckDriver.setDriverId(driverId);
        truckDriver.setFirstName(firstName);
        truckDriver.setLastName(lastName);
        truckDriver.setPsychoTestDate(psychoTestDate);
        truckDriver.setMedTestDate(medTestDate);
        truckDriver.setDriverLicenseDate(driverLicenseDate);
        truckDriverDao.saveTruckDriver(truckDriver);
        return "redirect:/truckdriver/list";
    }

    @GetMapping("/list")
    public String listTrucksDrivers(Model model) {
        List<TruckDriver> truckDrivers = truckDriverDao.getAllDrivers();
        model.addAttribute("truckDrivers", truckDrivers);
        return "truckdriver/list";
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
