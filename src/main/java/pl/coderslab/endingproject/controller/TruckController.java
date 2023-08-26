package pl.coderslab.endingproject.controller;


import org.springframework.web.bind.annotation.*;
import pl.coderslab.endingproject.dao.TruckDao;
import org.springframework.stereotype.Controller;
import pl.coderslab.endingproject.entity.Truck;

import java.time.Instant;

@Controller
@RequestMapping("/truck")
public class TruckController {

    private TruckDao truckDao;

    public TruckController(TruckDao truckDao) {
        this.truckDao = truckDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addTruckDriver(
            @RequestParam String truckModel,
            @RequestParam String truckPlates,
            @RequestParam String vinNumber,
            @RequestParam Instant serviceDate,
            @RequestParam Instant insuranceDate,
            @RequestParam int acctualSaldoPallets) {
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
    @ResponseBody
    public String getTruck(@PathVariable Long truckId) {
        Truck truck = truckDao.findByIdTruck(truckId);

        if (truck != null) {
            return truck.toString();
        } else {
            return "Truck o ID " + truckId + " nie istnieje.";
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
            return "Zaktualizowano trucka o ID " + truckId;
        } else {
            return "Truck o podanym ID nie istnieje";
        }
    }



    @ResponseBody
    @GetMapping("/delete")
    public String delete(
            @RequestParam Long truckId) {
        Truck truck = truckDao.findByIdTruck(truckId);
        if (truck != null) {
            truckDao.deleteTruck(truck);
            return "Usunięto trucka o ID " + truckId;
        } else {
            return "Truck o podanym ID nie istnieje";
        }
    }

}