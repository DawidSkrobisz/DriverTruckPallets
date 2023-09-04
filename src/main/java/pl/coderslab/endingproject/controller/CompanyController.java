package pl.coderslab.endingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.endingproject.dao.CompanyDao;
import pl.coderslab.endingproject.entity.Company;
import pl.coderslab.endingproject.entity.Truck;

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
    public String addCompany(@ModelAttribute Company company) {
        companyDao.saveCompany(company);
        return "redirect:/company/list";
    }

    @GetMapping("/list")
    public String listCompanys(Model model) {
        List<Company> companys = companyDao.getAllCompanys();
        model.addAttribute("companys", companys);
        return "company/list";
    }

    @GetMapping("/get/{companyId}")
    public String getCompany(@PathVariable Long companyId, Model model) {
        Company company = companyDao.findByIdCompany(companyId);
        if (company != null) {
            model.addAttribute("company", company);
            return "company/get";
        } else {
            return "Firma o ID " + companyId + " nie istnieje.";
        }
    }

    @GetMapping("/update/{companyId}")
    public String showUpdateCompanyForm(@PathVariable Long companyId, Model model) {
        Company company = companyDao.findByIdCompany(companyId);
        if (company != null) {
            model.addAttribute("company", company);
            model.addAttribute("companyId", companyId);
            return "company/update";
        } else {
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateCompany(@ModelAttribute Company company, @RequestParam Long companyId) {
        company.setCompanyId(companyId);
        companyDao.updateCompany(company);
        return "redirect:/company/list";
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