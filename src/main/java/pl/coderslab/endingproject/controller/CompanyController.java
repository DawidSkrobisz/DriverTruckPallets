package pl.coderslab.endingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.endingproject.dao.CompanyDao;
import pl.coderslab.endingproject.entity.Company;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private CompanyDao companyDao;

    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @GetMapping("/add")
    public String formAddCompany(Model model) {
        Company company = new Company();
        model.addAttribute("company", new Company());
        return "company/add";
    }

    @RequestMapping("/add")
    public String addCompany(
            @RequestParam String companyName,
            @RequestParam String companyAdress,
            @RequestParam String companyVat) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setCompanyAdress(companyAdress);
        company.setCompanyVat(companyVat);
        companyDao.saveCompany(company);
        return "redirect:/company/list";
    }


    @GetMapping("/list")
    public String listTrucks(Model model) {
        List<Company> companys = companyDao.getAllCompanys();
        model.addAttribute("companys", companys);
        return "company/list";
    }

    @GetMapping("/get/{companyId}")
    public String getTruck(@PathVariable Long companyId, Model model) {
        Company company = companyDao.findByIdCompany(companyId);

        if (company != null) {
            model.addAttribute("company", company);
            return "company/get";
        } else {
            return "Firma o ID " + companyId + " nie istnieje.";
        }
    }

    @ResponseBody
    @GetMapping("/update")
    public Company updateCompany() {
        Company company = companyDao.findByIdCompany(1L);
        company.setCompanyName("Oskroba");
        companyDao.updateCompany(company);
        return company;
    }

    @GetMapping("/delete")
    public String deleteCompany(@RequestParam Long id) {
        Company company = companyDao.findByIdCompany(id);
        if (company != null) {
            companyDao.deleteCompany(company);
        }
        return "redirect:/company/list";
    }

}