package pl.coderslab.endingproject.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pl.coderslab.endingproject.dao.TruckDriverDao;
import pl.coderslab.endingproject.entity.TruckDriver;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
            @RequestParam Long pesel,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate psychoTestDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate medTestDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate driverLicenseDate) {
        TruckDriver truckDriver = new TruckDriver();
        truckDriver.setFirstName(firstName);
        truckDriver.setLastName(lastName);
        truckDriver.setPesel(pesel);
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

    @GetMapping("/update/{driverId}")
    public String showUpdateTruckDriverForm(@PathVariable Long driverId, Model model) {
        TruckDriver truckDriver = truckDriverDao.getTruckDriver(driverId);
        if (truckDriver != null) {
            model.addAttribute("truckDriver", truckDriver);
            model.addAttribute("driverId", driverId);
            return "truckdriver/update";
        } else {
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateTruckDriver(@ModelAttribute TruckDriver truckDriver, @RequestParam Long driverId) {
        truckDriver.setDriverId(driverId);
        truckDriverDao.updateTruckDriver(truckDriver);
        return "redirect:/truckdriver/list";
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