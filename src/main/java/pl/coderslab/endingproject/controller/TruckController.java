package pl.coderslab.endingproject.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.endingproject.dao.TruckDao;
import org.springframework.stereotype.Controller;
import pl.coderslab.endingproject.entity.Truck;

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
    @ResponseBody
    public String addTruck(
            @RequestParam String truckModel,
            @RequestParam String truckPlates,
            @RequestParam String vinNumber,
            @RequestParam String serviceDateStr,
            @RequestParam String insuranceDateStr,
            @RequestParam int acctualSaldoPallets) {

        Instant serviceDate = LocalDate.parse(serviceDateStr).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Instant insuranceDate = LocalDate.parse(insuranceDateStr).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        Truck truck = new Truck();
        truck.setTruckModel(truckModel);
        truck.setTruckPlates(truckPlates);
        truck.setVinNumber(vinNumber);
        truck.setServiceDate(serviceDate);
        truck.setInsuranceDate(insuranceDate);
        truck.setAcctualSaldoPallets(acctualSaldoPallets);

        truckDao.saveTruck(truck);

        return "Dodano ciężarówkę do bazy danych";
    }

    @GetMapping("/get/{truckId}")
    public String getTruck(@PathVariable Long truckId, Model model) {
        Truck truck = truckDao.findByIdTruck(truckId);

        if (truck != null) {
            model.addAttribute("truck", truck);
            return "truck/get-truck";
        } else {
            return "Ciężarówka o ID " + truckId + " nie istnieje.";
        }
    }

    @GetMapping("/list")
    public String listTrucks(Model model) {
        List<Truck> trucks = truckDao.getAllTrucks();
        model.addAttribute("trucks", trucks);
        return "truck/truck-list";
    }

    @GetMapping("/get/{truckId}/details")
    public String showTruckDetails(@PathVariable Long truckId, Model model) {
        Truck truck = truckDao.findByIdTruck(truckId);

        if (truck != null) {
            model.addAttribute("truck", truck);
            return "truck/get-truck";
        } else {
            return "error";
        }
    }

    @ResponseBody
    @GetMapping("/update")
    public String updateTruck(
            @RequestParam Long truckId,
            @RequestParam String newTruckModel) {
        Truck truck = truckDao.findByIdTruck(truckId);
        if (truck != null) {
            truck.setTruckModel(newTruckModel);
            truckDao.updateTruck(truck);
            return "Zaktualizowano ciężarówkę o ID " + truckId;
        } else {
            return "Ciężarówka o ID nie istnieje";
        }
    }


    @ResponseBody
    @GetMapping("/delete")
    public String delete(
            @RequestParam Long truckId) {
        Truck truck = truckDao.findByIdTruck(truckId);
        if (truck != null) {
            truckDao.deleteTruck(truck);
            return "Usunięto ciężarówkę o ID " + truckId;
        } else {
            return "Ciężarówka o ID nie istnieje";
        }
    }

}