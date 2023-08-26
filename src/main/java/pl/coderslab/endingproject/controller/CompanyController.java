package pl.coderslab.endingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.endingproject.dao.CompanyDao;
import pl.coderslab.endingproject.entity.Company;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private CompanyDao companyDao;

    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addCompany(@ModelAttribute Company company) {
        company.setCompanyName("Intereuropol");
        company.setCompanyAdress("Marki");
        company.setCompanyVat("151-151-26-26");
        companyDao.saveCompany(company);
        return "Dodano nową firmę";
    }

    @GetMapping("/get")
    @ResponseBody
    public Company getCompany() {
        return companyDao.findByIdCompany(1L);
    }

    @ResponseBody
    @GetMapping("/update")
    public Company updateCompany() {
        Company company = companyDao.findByIdCompany(1L);
        company.setCompanyName("Oskroba");
        companyDao.updateCompany(company);
        return company;
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteCompany() {
        Company company = companyDao.findByIdCompany(1L);
        companyDao.deleteCompany(company);
        return "Skasowano firmę";
    }
}