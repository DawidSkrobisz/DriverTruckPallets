package pl.coderslab.endingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.endingproject.dao.LoadingDao;
import pl.coderslab.endingproject.entity.Loading;

@Controller
@RequestMapping("/palette")
public class LoadingController {

    private LoadingDao loadingDao;

    public LoadingController(LoadingDao loadingDao) {
        this.loadingDao = loadingDao;
    }

    @GetMapping("/get/{companyId}")
    public String loadingsDetails(@PathVariable Long companyId, Model model) {
        Loading loading = loadingDao.findByIdLoading(companyId);
        if (loading != null) {
            Long companyName = loading.getCompany().getCompanyId();
            model.addAttribute("loading", loading);
            model.getAttribute("companyId");
            return "loading/get";
        } else {
            return "error";
        }
    }
}
