package pl.coderslab.endingproject.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pl.coderslab.endingproject.dao.TruckDriverDao;
import pl.coderslab.endingproject.entity.Company;
import pl.coderslab.endingproject.entity.TruckDriver;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    @RequestMapping("/add")
    public String addTruckDriver(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate psychoTestDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate medTestDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate driverLicenseDate) {

        TruckDriver truckDriver = new TruckDriver();
        truckDriver.setFirstName(firstName);
        truckDriver.setLastName(lastName);
        truckDriver.setPsychoTestDate(psychoTestDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        truckDriver.setMedTestDate(medTestDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        truckDriver.setDriverLicenseDate(driverLicenseDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        truckDriverDao.saveTruckDriver(truckDriver);
        return "redirect:/truckdriver/list";
    }

    @GetMapping("/list")
    public String listTrucksDrivers(Model model) {
        List<TruckDriver> truckDrivers = truckDriverDao.getAllDrivers();
        model.addAttribute("truckDrivers", truckDrivers);
        return "truckdriver/list";
    }

    @GetMapping("/get/{driverId}")
    public String driverDetails(@PathVariable Long driverId, Model model) {
        TruckDriver truckDriver = truckDriverDao.getTruckDriver(driverId);

        if (truckDriver != null) {
            model.addAttribute("truckDriver", truckDriver);
            return "truckdriver/get";
        } else {
            return "error";
        }
    }


    @ResponseBody
    @GetMapping("/update")
    public TruckDriver updateTruckDriver() {
        TruckDriver truckDriver = truckDriverDao.getTruckDriver(1L);
        truckDriver.setFirstName("Michail");
        truckDriverDao.updateTruckDriver(truckDriver);
        return truckDriver;
    }

    @GetMapping("/delete")
    public String deleteTruckDriver(@RequestParam Long id) {
        TruckDriver truckDriver = truckDriverDao.getTruckDriver(id);
        if (truckDriver != null) {
            truckDriverDao.delete(truckDriver);
        }
        return "redirect:/truckdriver/list";
    }


}
