package pl.coderslab.endingproject.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.endingproject.dao.TruckDao;
import org.springframework.stereotype.Controller;
import pl.coderslab.endingproject.entity.Truck;
import pl.coderslab.endingproject.entity.TruckDriver;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/truck")
public class TruckController {

    private TruckDao truckDao;

    public TruckController(TruckDao truckDao) {
        this.truckDao = truckDao;
    }

    @GetMapping("/add")
    public String formAdd(Model model) {
        Truck truck = new Truck();
        model.addAttribute("truck", truck);
        return "truck/add";
    }

    @RequestMapping("/add")
    public String addTruck(
            @RequestParam String truckModel,
            @RequestParam String truckPlates,
            @RequestParam String vinNumber,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate serviceDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate insuranceDate,
            @RequestParam int acctualSaldoPallets) {

        Truck truck = new Truck();
        truck.setTruckModel(truckModel);
        truck.setTruckPlates(truckPlates);
        truck.setVinNumber(vinNumber);
        truck.setServiceDate(serviceDate);
        truck.setInsuranceDate(insuranceDate);
        truck.setAcctualSaldoPallets(acctualSaldoPallets);
        truckDao.saveTruck(truck);
        return "redirect:/truck/list";
    }

    @GetMapping("/details/{truckId}")
    public String truckDetails(@PathVariable Long truckId, Model model) {
        Truck truck = truckDao.findByIdTruck(truckId);
        if (truck != null) {
            model.addAttribute("truck", truck);
            return "truck/get-truck";
        } else {
            return "error";
        }
    }

    @GetMapping("/list")
    public String listTrucks(Model model) {
        List<Truck> trucks = truckDao.getAllTrucks();
        model.addAttribute("trucks", trucks);
        return "truck/truck-list";
    }


    @GetMapping("/update/{truckId}")
    public String showUpdateTruckDriverForm(@PathVariable Long truckId, Model model) {
        Truck truck = truckDao.findByIdTruck(truckId);
        if (truck != null) {
            model.addAttribute("truck", truck);
            model.addAttribute("truckId", truckId);
            return "truck/update";
        } else {
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateTruckDriver(@ModelAttribute Truck truck, @RequestParam Long truckId) {
        truck.setTruckId(truckId);
        truckDao.updateTruck(truck);
        return "redirect:/truck/list";
    }


    @GetMapping("/delete")
    public String deleteTruck(@RequestParam Long id) {
        Truck truck = truckDao.findByIdTruck(id);
        if (truck != null) {
            truckDao.deleteTruck(truck);
        }
        return "redirect:/truck/list";
    }
}