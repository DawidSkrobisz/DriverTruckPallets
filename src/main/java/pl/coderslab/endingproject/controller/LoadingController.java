package pl.coderslab.endingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.endingproject.dao.LoadingDao;

@Controller
@RequestMapping("/palette")
public class LoadingController {

    private LoadingDao loadingDao;

    public LoadingController(LoadingDao loadingDao) {
        this.loadingDao = loadingDao;
    }
}
