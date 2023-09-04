package pl.coderslab.endingproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.endingproject.dao.CompanyDao;
import pl.coderslab.endingproject.entity.Company;

@Component
public class CompanyConverter implements Converter<String, Company> {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public Company convert(String companyId) {
        if (companyId == null || companyId.isEmpty()) {
            return null;
        }
        Long id = Long.parseLong(companyId);
        return companyDao.findByIdCompany(id);
    }
}
