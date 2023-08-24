package controller;


import dao.TruckDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/truck")
public class TruckController {

    private TruckDao truckDao;

    public TruckController(TruckDao truckDao) {
        this.truckDao = truckDao;
    }
}
