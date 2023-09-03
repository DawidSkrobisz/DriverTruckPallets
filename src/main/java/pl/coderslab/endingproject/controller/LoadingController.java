package pl.coderslab.endingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.endingproject.dao.CompanyDao;
import pl.coderslab.endingproject.dao.LoadingDao;
import pl.coderslab.endingproject.dao.TruckDao;
import pl.coderslab.endingproject.entity.Company;
import pl.coderslab.endingproject.entity.Loading;
import pl.coderslab.endingproject.entity.Truck;

import java.util.List;

@Controller
@RequestMapping("/palette")
public class LoadingController {

    private LoadingDao loadingDao;
    private CompanyDao companyDao;
    private TruckDao truckDao;

    public LoadingController(LoadingDao loadingDao, CompanyDao companyDao, TruckDao truckDao) {
        this.loadingDao = loadingDao;
        this.companyDao = companyDao;
        this.truckDao = truckDao;
    }

    @GetMapping("/add")
    public String formAdd(Model model) {
        Loading loading = new Loading();
        model.addAttribute("loading", loading);

        List<Company> companies = companyDao.getAllCompanys();
        model.addAttribute("companies", companies);

        List<Truck> trucks = truckDao.getAllTrucks();
        model.addAttribute("trucks", trucks);

        return "loading/add";
    }

    @PostMapping("/add")
    public String addLoading(@ModelAttribute("loading") Loading loading) {
        loadingDao.saveLoading(loading);
        return "redirect:/palette/list";
    }

    @GetMapping("/get/{companyId}")
    public String loadingsDetails(@PathVariable Long companyId, Model model) {
        Loading loading = loadingDao.findByIdLoading(companyId);
        if (loading != null) {
            Long companyName = loading.getCompany().getCompanyId();
            model.addAttribute("loading", loading);
            model.addAttribute("companyName", companyName);
            return "loading/get";
        } else {
            return "error";
        }
    }

    @GetMapping("/list")
    public String listTrucks(Model model) {
        List<Loading> loadings = loadingDao.getAllLoadings();
        model.addAttribute("loadings", loadings);
        return "loading/list";
    }

}