package controller;

import entity.TruckDriver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/truckdriver")
public class TruckDriverController {

    TruckDriver truckDriverDao;

    public TruckDriverController(TruckDriver truckDriverDao) {
        this.truckDriverDao = truckDriverDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addTruckDriver(@ModelAttribute TruckDriver truckDriver) {
        truckDriverDao.saveTruckDriver(truckDriver);
        return "Truck driver added successfully!";
    }
}
