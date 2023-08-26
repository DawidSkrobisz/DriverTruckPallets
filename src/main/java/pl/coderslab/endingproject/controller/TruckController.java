package pl.coderslab.endingproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.endingproject.dao.TruckDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String addTruckDriver(@ModelAttribute Truck truck) {
        truck.setTruckModel("MAN TGA");
        truck.setTruckPlates("WGR667W");
        truck.setVinNumber("WVW2982493483958");
        truck.setServiceDate(Instant.now());
        truck.setInsuranceDate(Instant.now());
        truck.setAcctualSaldoPallets(33);
        truckDao.saveTruck(truck);
        return "Dodano ciężarówkę do bazy danych";
    }

    @GetMapping("/get")
    @ResponseBody
    public Truck getTruck() {
        return truckDao.findByIdTruck(1L);
    }

    @ResponseBody
    @GetMapping("/update")
    public Truck updateTruck() {
        Truck truck = truckDao.findByIdTruck(1L);
        truck.setTruckModel("Volvo");
        truckDao.updateTruck(truck);
        return truck;
    }

    @ResponseBody
    @GetMapping("/delete")
    public String delete() {
        Truck truck = truckDao.findByIdTruck(1L);
        truckDao.deleteTruck(truck);
        return "Skasowano kierowcę";
    }
}
